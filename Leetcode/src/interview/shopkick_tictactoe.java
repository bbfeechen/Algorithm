package interview;

public class shopkick_tictactoe {
    public static int BOARD_SIZE = 3;
    protected static int EMPTY = 0;

    public static void main(String[] args) {
        int[][]         board = new int[BOARD_SIZE][BOARD_SIZE];
        int             i;
        int             j;
        int[]           move = new int[2];
        int             player;
        int             value;
        int             moves;

        // Inititalize board to be empty
        for(i = 0; i < BOARD_SIZE; i = i + 1) {
            for(j = 0; j < BOARD_SIZE; j = j + 1) {
                board[i][j] = EMPTY;
            }
        }

        // Keep moving. (We finish when game is done)
        player = 1;
        for(moves = 0; true; moves = moves + 1) {
            // Print board
            for(i = 0; i < BOARD_SIZE; i = i + 1) {
                for(j = 0; j < BOARD_SIZE; j = j + 1) {
                    if(board[i][j] == EMPTY) {
                        System.out.print("-");
                    } else if(board[i][j] > 0) {
                        System.out.print("X");
                    } else {
                        System.out.print("O");
                    }
                }
                System.out.println();
            }
            
            // Get value of board
            value = TicTacMove(board, player, move);
            if(move[0] < 0) {
                if(value == 0) {
                    System.out.println("Cat's game");
                } else if(value > 0) {
                    System.out.println("X won");
                } else {
                    System.out.println("O won");
                }
                return;
            }
            board[move[0]][move[1]] = player;
            
            // Print information about move
            System.out.print("Move " + (moves + 1) + ": ");
            if(player > 0) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
            System.out.print(" plays at (" + (move[0] + 1) + "," + (move[1] + 1) + ") [");
            if(value == 0) {
                System.out.print("nobody");
            } else if(value > 0) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
            System.out.println(" will win]");
            
            // Switch players for next move
            player = -player;
        }
    }

    // TicTacMove
    //
    // Find the best move for whosemove and place it into (best_place[0], best_place[1]).
    // Return the value of the board. If the board is a final state, then put -1 into
    // best_place[0].
    public static int TicTacMove(int[][] board, int whosemove, int[] best_place) {
        int             i;
        int             j;
        int[]           place = new int[2];
        int             best;
        int             value;

        // See if anybody has won
        value = TicTacFinal(board);
        if(value != EMPTY) {
            best_place[0] = -1;
            return value;
        }

        // Try each available move and maximize (or minimize)
        best = -2 * whosemove; // anything will beat this
        for(i = 0; i < BOARD_SIZE; i = i + 1) {
            for(j = 0; j < BOARD_SIZE; j = j + 1) {
                if(board[i][j] == EMPTY) {
                    // Try moving here, see its value, then undo move
                    board[i][j] = whosemove;
                    value = TicTacMove(board, -whosemove, place);
                    board[i][j] = EMPTY;

                    // See if value is better than what we have
                    if((whosemove < 0 && value < best)
                            || (whosemove > 0 && value > best)) {
                        best = value;
                        best_place[0] = i;
                        best_place[1] = j;
                    }

                    if(best == whosemove) {
                        // Then I found a guaranteed win; take it.
                        return best;
                    }
                }
            }
        }

        if(best == -2 * whosemove) {
            // No empty spaces are on board; it's a cat's game.
            best_place[0] = -1;
            return 0;
        }

        return best;
    }

    
    // TicTacFinal
    //
    // returns the code of the player that has won in the board, or EMPTY
    // if neither has won.
    public static int TicTacFinal(int[][] board) {
        int             i;
        int             j;
        int             k;

        // See if any row is filled by a player
        for(i = 0; i < BOARD_SIZE; i = i + 1) {
            k = board[i][0];
            if(k != EMPTY) {
                for(j = 1; j < BOARD_SIZE; j = j + 1) {
                    if(board[i][j] != k) {
                        break;
                    }
                }
                if(j == BOARD_SIZE) {
                    // then k has filled row
                    return k;
                }
            }
        }

        // See if any column is filled by a player
        for(j = 0; j < BOARD_SIZE; j = j + 1) {
            k = board[0][j];
            if(k != EMPTY) {
                for(i = 1; i < BOARD_SIZE; i = i + 1) {
                    if(board[i][j] != k) {
                        break;
                    }
                }
                if(i == BOARD_SIZE) {
                    // then k has filled column
                    return k;
                }
            }
        }

        // See if \ diagonal is filled by a player
        k = board[0][0];
        if(k != EMPTY) {
            for(i = 0; i < BOARD_SIZE; i = i + 1) {
                if(board[i][i] != k) {
                    break;
                }
            }
            if(i == BOARD_SIZE) {
                // then k has filled \ diagonal
                return k;
            }
        }

        // See if / diagonal is filled by a player
        k = board[0][BOARD_SIZE - 1];
        if(k != EMPTY) {
            for(i = 0; i < BOARD_SIZE; i = i + 1) {
                if(board[i][BOARD_SIZE - 1 - i] != k) {
                    break;
                }
            }
            if(i == BOARD_SIZE) {
                // then k has filled / diagonal
                return k;
            }
        }

        return EMPTY;
    }
}
