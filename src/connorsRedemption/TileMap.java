package connorsRedemption;

public class TileMap {
	
	private Map mapa;
	
	public TileMap(int lin, int col) {
		this.mapa = new Map(lin, col);
		this.mapa.getMap().get(0).setBlocked(true);
	    this.mapa.getMap().get(1).setBlocked(true);
	    this.mapa.getMap().get(2).setBlocked(true);
	    this.mapa.getMap().get(6).setBlocked(true);
	    this.mapa.getMap().get(13).setBlocked(true);
	    this.mapa.getMap().get(27).setBlocked(true);
	    this.mapa.getMap().get(28).setBlocked(true);
	    this.mapa.getMap().get(29).setBlocked(true);
	    this.mapa.getMap().get(33).setBlocked(true);
	    this.mapa.getMap().get(40).setBlocked(true);
	    this.mapa.getMap().get(54).setBlocked(true);
	    this.mapa.getMap().get(55).setBlocked(true);
	    this.mapa.getMap().get(56).setBlocked(true);
	    this.mapa.getMap().get(60).setBlocked(true);
	    this.mapa.getMap().get(67).setBlocked(true);
	    this.mapa.getMap().get(81).setBlocked(true);
	    this.mapa.getMap().get(82).setBlocked(true);
	    this.mapa.getMap().get(83).setBlocked(true);
	    this.mapa.getMap().get(87).setBlocked(true);
	    this.mapa.getMap().get(88).setBlocked(true);
	    this.mapa.getMap().get(89).setBlocked(true);
	    this.mapa.getMap().get(92).setBlocked(true);
	    this.mapa.getMap().get(93).setBlocked(true);
	    this.mapa.getMap().get(94).setBlocked(true);
	    this.mapa.getMap().get(95).setBlocked(true);
	    this.mapa.getMap().get(96).setBlocked(true);
	    this.mapa.getMap().get(97).setBlocked(true);
	    this.mapa.getMap().get(98).setBlocked(true);
	    this.mapa.getMap().get(99).setBlocked(true);
	    this.mapa.getMap().get(100).setBlocked(true);
	    this.mapa.getMap().get(101).setBlocked(true);
	    this.mapa.getMap().get(102).setBlocked(true);
	    this.mapa.getMap().get(103).setBlocked(true);
	    this.mapa.getMap().get(104).setBlocked(true);
	    this.mapa.getMap().get(106).setBlocked(true);
	    this.mapa.getMap().get(107).setBlocked(true);
	    this.mapa.getMap().get(108).setBlocked(true);
	    this.mapa.getMap().get(109).setBlocked(true);
	    this.mapa.getMap().get(110).setBlocked(true);
	    this.mapa.getMap().get(113).setBlocked(true);
	    this.mapa.getMap().get(116).setBlocked(true);
	    this.mapa.getMap().get(117).setBlocked(true);
	    this.mapa.getMap().get(118).setBlocked(true);
	    this.mapa.getMap().get(119).setBlocked(true);
	    this.mapa.getMap().get(122).setBlocked(true);
	    this.mapa.getMap().get(123).setBlocked(true);
	    this.mapa.getMap().get(124).setBlocked(true);
	    this.mapa.getMap().get(125).setBlocked(true);
	    this.mapa.getMap().get(149).setBlocked(true);
	    this.mapa.getMap().get(150).setBlocked(true);
	    this.mapa.getMap().get(151).setBlocked(true);
	    this.mapa.getMap().get(152).setBlocked(true);
	    this.mapa.getMap().get(176).setBlocked(true);
	    this.mapa.getMap().get(177).setBlocked(true);
	    this.mapa.getMap().get(178).setBlocked(true);
	    this.mapa.getMap().get(179).setBlocked(true);
	    this.mapa.getMap().get(190).setBlocked(true);
	    this.mapa.getMap().get(191).setBlocked(true);
	    this.mapa.getMap().get(217).setBlocked(true);
	    this.mapa.getMap().get(218).setBlocked(true);
	    this.mapa.getMap().get(225).setBlocked(true);
	    this.mapa.getMap().get(226).setBlocked(true);
	    this.mapa.getMap().get(227).setBlocked(true);
	    this.mapa.getMap().get(228).setBlocked(true);
	    this.mapa.getMap().get(239).setBlocked(true);
	    this.mapa.getMap().get(240).setBlocked(true);
	    this.mapa.getMap().get(244).setBlocked(true);
	    this.mapa.getMap().get(245).setBlocked(true);
	    this.mapa.getMap().get(248).setBlocked(true);
	    this.mapa.getMap().get(249).setBlocked(true);
	    this.mapa.getMap().get(250).setBlocked(true);
	    this.mapa.getMap().get(251).setBlocked(true);
	    this.mapa.getMap().get(252).setBlocked(true);
	    this.mapa.getMap().get(255).setBlocked(true);
	    this.mapa.getMap().get(256).setBlocked(true);
	    this.mapa.getMap().get(257).setBlocked(true);
	    this.mapa.getMap().get(258).setBlocked(true);
	    this.mapa.getMap().get(264).setBlocked(true);
	    this.mapa.getMap().get(265).setBlocked(true);
	    this.mapa.getMap().get(266).setBlocked(true);
	    this.mapa.getMap().get(267).setBlocked(true);
	    this.mapa.getMap().get(268).setBlocked(true);
	    this.mapa.getMap().get(269).setBlocked(true);
	    this.mapa.getMap().get(275).setBlocked(true);
	    this.mapa.getMap().get(276).setBlocked(true);
	    this.mapa.getMap().get(277).setBlocked(true);
	    this.mapa.getMap().get(284).setBlocked(true);
	    this.mapa.getMap().get(292).setBlocked(true);
	    this.mapa.getMap().get(302).setBlocked(true);
	    this.mapa.getMap().get(303).setBlocked(true);
	    this.mapa.getMap().get(304).setBlocked(true);
	    this.mapa.getMap().get(311).setBlocked(true);
	    this.mapa.getMap().get(319).setBlocked(true);
	    this.mapa.getMap().get(331).setBlocked(true);
	    this.mapa.getMap().get(338).setBlocked(true);
	    this.mapa.getMap().get(358).setBlocked(true);
	    this.mapa.getMap().get(365).setBlocked(true);
	    this.mapa.getMap().get(385).setBlocked(true);
	    this.mapa.getMap().get(392).setBlocked(true);
	    
	}
	
	public Map getMap() {
		return this.mapa;
	}

}
