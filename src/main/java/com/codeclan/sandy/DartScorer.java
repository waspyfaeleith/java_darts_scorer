package com.codeclan.sandy;

/**
 * Darts scorer
 *
 */
public class DartScorer 
{
    public static void main( String[] args )
    {
        System.out.println( "Lets play darts!" );
        Viewer viewer = new Viewer();
        
        String player1 = viewer.getPlayerName(1);
        String player2 = viewer.getPlayerName(2);
        int sets = viewer.bestOf("sets");
        int legsPerSet = viewer.bestOf("legs");
        int startScore = viewer.getStartScore();
        		
        Match match = new Match(player1, player2, sets, legsPerSet, startScore);
        match.play();
    }
}
