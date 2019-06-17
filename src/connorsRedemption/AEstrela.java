package connorsRedemption;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;        

public class AEstrela {
    public static List<Node> listaFechada = new ArrayList();
    public static List<Node> listaAberta = new ArrayList();
    public static List<Node> listaCaminho = new ArrayList();
    public static int colunasDoMapa = 0;
    public static int linhasDoMapa = 0;
    public static int tamanhoDoMapa = 0;
    
    public static List<Node> aEstrela(Node noInicial, Node noDestino, Map mapa){
        colunasDoMapa = mapa.getColumns();
        linhasDoMapa = mapa.getLines();
        tamanhoDoMapa = mapa.getSize();
        
        listaFechada.clear();
        listaAberta.clear();
        
        boolean achouCaminho = false;
        
        Node noAtual = noInicial;
        listaAberta.add(noInicial);
        
        while(!achouCaminho){
            noAtual = procurarMenorF();
            listaAberta.remove(noAtual);
            listaFechada.add(noAtual);
            achouCaminho = noAtual.equals(noDestino);
            
            for(Node no: noAtual.getNodes()){
                if(no.isBlocked() || listaFechada.contains(no)){
                    continue;
                }else if(!listaAberta.contains(no)){
                    listaAberta.add(no);
                    no.setFather(noAtual);
                    no.setH(calcularH(no, noDestino));
                    no.setG(calcularG(no, noAtual));
                    no.setF(calcularF(no));
                }else if(no.getG() < noAtual.getG()){
                    no.setFather(noAtual);
                    no.setG(calcularG(noAtual, no));
                    no.setF(calcularF(no));
                }
            }
            if(listaAberta.isEmpty()){
                System.out.println("Não achou caminho");
                return null;
            }
        }
        return montaCaminho(noInicial, noDestino, mapa);
    }
    
    private static Node procurarMenorF(){
        Collections.sort(listaAberta, Comparator.comparing(Node::getF));
        return listaAberta.get(0);
    }
    
    private static float calcularH(Node noAtual, Node noDestino){
        int posicaoDestinoX = (noDestino.getID() % colunasDoMapa) + 1;
        int posicaoNoAtualX = (noAtual.getID() % colunasDoMapa) + 1;
        
        int distanciaX = posicaoDestinoX > posicaoNoAtualX ? posicaoDestinoX - posicaoNoAtualX : posicaoNoAtualX - posicaoDestinoX;
        
        int posicaoDestinoY = (noDestino.getID() / linhasDoMapa) + 1;
        int posicaoNoAtualY = (noAtual.getID() / linhasDoMapa) + 1;
        
        int distanciaY = posicaoDestinoY > posicaoNoAtualY ? posicaoDestinoY - posicaoNoAtualY : posicaoNoAtualY - posicaoDestinoY;
        
        return (float)Math.sqrt(Math.pow(distanciaX,2) + Math.pow(distanciaY,2))*10;
    }
    
    private static float calcularG(Node noAtual, Node noVizinho){
        if(noVizinho.getID() % colunasDoMapa == noAtual.getID() % colunasDoMapa || 
           noVizinho.getID() + 1 == noAtual.getID() || 
           noVizinho.getID() - 1 == noAtual.getID()){
           
           return noVizinho.getG()+10;
        }
        return noVizinho.getG()+14;
    }
    
    private static float calcularF(Node no){
        return no.getG() + no.getH();
    }
    
    private static List<Node> montaCaminho(Node noInicial, Node noDestino, Map mapa) {
        List<Node> listaAuxiliar = new ArrayList();
        Node noAtual = noDestino;
        int contador = 0;
        while (!listaAuxiliar.contains(noInicial) || contador > tamanhoDoMapa){
            listaAuxiliar.add(noAtual);

            noAtual = noAtual.getFather();
                        
            contador++;
        }

        Collections.reverse(listaAuxiliar);
        
        /*
        //imprimir caminho
        System.out.println("Caminho: ");
        for(Node no: listaAuxiliar){
            System.out.print(" -> " + no.getID());
        }
        
        //inicio artificio apenas para printar caminho
        for(Node no: mapa.getMap()){
          if(!listaAuxiliar.contains(no))  no.setFather(null);
          
        }
        //fim do artificio
        
        System.out.println("");
        desenha(mapa);
        System.out.println("Fim ! ");
        
        */
        
        //retorno do caminho
        return listaAuxiliar;
    }
    
    public static void desenha(Map mapa){
        System.out.println("");
        for (int i = 0; i<mapa.getLines(); i++){
            for (int j = 0; j<mapa.getColumns(); j++){
                Node no = mapa.getMap().get((i*mapa.getColumns())+j);
                if(no.getFather() != null ){
                    System.out.print("[-]");
                }else if(no.isBlocked()){
                    System.out.print("[X]");
                }else{
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}

