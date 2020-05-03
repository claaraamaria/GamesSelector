package com.example.gamesselector3;

import java.util.ArrayList;
import java.util.List;

public class FactoryCardsInfo {
    public static List<Data> getCardsInfo(String cardType) {
        List<Data> array = new ArrayList<>();
        switch (cardType) {
            case "ListBoardGames":
                array.add(new Data("board_game", "For this kind of games, a link with the complete rules will be listed."));
                array.add(new Data("Football (Soccer)", "Catan\n"));
                array.add(new Data("board_game", "Dixit \n"));
                array.add(new Data("drinking_games", "Cards against humanity \n"));
                break;

            case "ListCardGames":
                array.add(new Data("Football (Soccer)", "SlapJack\n" +
                        "Going around the circle, each player draws a card from the top of their deck (face-out, so that the player cannot see the card before it is played) and places that card in the center of the circle. Each player continues to place their cards in the center this way.\n" +
                        "When a Jack court card is turned face up, the goal is to be the first person to “slap” it, or cover it with your hand. If several people slap at once, the person whose hand is most in contact with the Jack adds all the cards to his or her pile. "));
                array.add(new Data("board_game", "Crazy Eights \n" +
                        "Deal 5 cards one at a time, face down, starting with the player to the dealer’s left. Place the rest of the cards face down in the center of the table, then turn the first card up and place it beside the facedown pile. If an eight is turned, it is buried in the middle of the pack and the next card is turned. The face-up cards create a “starter” pile. \n" +
                        "Starting to the dealer’s left, each player places one card face up on the starter pile. Each card played (other than an eight) must match the card showing at the top of the starter pile in suit or denomination. So if the king of Clubs is the starter, the card played must either be another king, or be any card from the clubs suit. If unable to play a card, the player draws cards from the top of the facedown cards until a play is possible.\n"));
                array.add(new Data("drinking_games", "Play or pay \n" +
                        "Each player starts by putting one chip (or jelly bean) into the pot before each deal. Deal the cards one at a time clockwise, face down, beginning with the player on the left. If some players receive fewer cards than others, it is customary for each player to add one additional chip. \n" +
                        "Starting with the player left of the dealer, the first person lays a card. All cards played remain face up on the table, arranged in four rows of the four suits. The first player may play any card. The sequence in the suit must be built up until all thirteen cards are played, and the sequence in the suit is continuous.\n"));
                break;

            case "ListBallGames":
                array.add(new Data("Football (Soccer)", "Football (Soccer)\n" +
                        "Number of Players: A match is played by two teams, each with a maximum of eleven players. \n" +
                        "Time: 100 minutes with breaks.\n" +
                        "Rules: The aim of football is to score more goals then your opponent in a 90 minute playing time frame. "));
                array.add(new Data("board_game", "Basketball \n" +
                        "Number of Players: Each team is made up of 12 players with only 5 allowed on the court at any time. \n" +
                        "Time: The game is split up into 4 twelve minute quarters. In between the 2 nd and 3rd quarter is a 15 minute half time interval.\n" +
                        "Rules: Each team can have a maximum of 5 players on the court at any one time. Substitutions can be made as many times as they wish within the game."));
                array.add(new Data("drinking_games", "Handball \n" +
                        "Number of Players: 7 players on each side, six outfield players and one goalkeeper. \n" +
                        "Time: A match consists of two periods of 30 minutes each.\n" +
                        "Rules: If a player holds possession, they can dribble or take three steps for up to three seconds without dribbling. "));
                array.add(new Data("ball_games", "Footballtennis (futnet) \n" +
                        "Number of Players: 2 or 4 players \n" +
                        "Time: A match consists of two periods of 30 minutes each.\n" +
                        "Rules: In all the disciplines, a set finishes with 11th point with a two-point difference, maximum score is 15:14. To win a match, the team has to win 2 sets. "));
                break;

            case "ListDrinkingGames":
                array.add(new Data("board_game", "Please drink responsibly \n" +
                        "This kind of games do not have time or number of persons required."));
                array.add(new Data("Football (Soccer)", "Never Have I Ever\n" +
                        "Rules: You have to share something that you have never done before and the people who have will take a sip of their drink."));
                array.add(new Data("board_game", "Thumper \n" +
                        "Rules: All you need to do is sit around a table and pick a hand motion for yourself. You could choose a victory sign or let your imagination run wild (or dirty ;) ). Everyone thumps at the table and the game begins. You start your hand action and then do someone else's action, while the others continue thumping. \n" +
                        "Now, the person whose hand action was done repeats his action, and of the one whose turn he wants next. Whoever messes up or takes too long to react, drinks. To make the game more fun, you could also make a sound for everyone and do the action AND the sound. Get it?"));
                array.add(new Data("drinking_games", "Straight Face \n" +
                        "You write funny or inappropriate sentences on small pieces of paper - ones that are tough to read while keeping a straight face. Each player picks up a chit of paper and tries to keep a straight face. The one who giggles or reacts has to drink!"));
                array.add(new Data("ball_games", "Buzz \n" +
                        "One of the easiest games, each player starts counting a number and says it aloud, except 7 and its multiples, in which case, you say buzz. If you don't, you drink. Simple!"));
                break;

            case "ListInteractiveGames":
                array.add(new Data("Football (Soccer)", "Hide and seek\n" +
                        "Number of Players: As many as possible. \n" +
                        "Time: A time can be set in order for the seeker to find the players.\n" +
                        "Rules: one player closes his or her eyes for a brief period (often counting to 100) while the other players hide. \n" +
                        "The seeker then opens his eyes and tries to find the hiders; the first one found is the next seeker, and the last is the winner of the round"));
                array.add(new Data("board_game", "Dodgeball \n" +
                        "Number of Players: minimum of 4\n" +
                        "Rules:Each team starts with ONE (1) ball and then there are TWO (2) balls evenly spread on the center line at the beginning of each game. It is a sprint to the TWO (2) balls once the play begins. There is a five (5) second grace period after the initial rush before balls can be thrown."));
                array.add(new Data("drinking_games", "Tag \n" +
                        "Number of Players: 7 players on each side, six outfield players and one goalkeeper. \n" +
                        "Rules: He/she can then start chasing the others, trying to tag them. Everyone who is \"not it\" will run away from the person who is \"it\" and try to avoid getting tagged.  "));
                break;
        }
        return array;
    }
}
