package ai.heuristics.specific;

import ai.Objective;
import ai.heuristics.Heuristic;
import ai.heuristics.Rating;
import main.Board;
import main.LegalMoveChecker;

/**
 * Determines whether a move will make 8 in a row - 
 * being a group that is always alive 
 */

public class EightStonesInARow implements Heuristic {

	@Override
	// / gives a board a move, obj and player to move
	// should return HAS_EIGHT_IN_A_ROW if a move
	public int assess(Board initialBoard, Board b, LegalMoveChecker lmc,
			Objective obj, int colourAI) {

		int x_limit = b.getWidth() - 1;
		int y_limit = b.getHeight() - 1;

		int stone_counter = 0;
		byte[][] board_to_assess = b.getRaw();
		byte[][] initialB = initialBoard.getRaw();
		// iterate over the board
		// only search edge rows + columns [1,y], [x,1], [width -1,y] and [x,
		// height-1]

		// search [1,y] for 8 in a row
		stone_counter = 0;
		for (int y = 0; y < y_limit; y++) {
			if (board_to_assess[1][y] == colourAI) {
				stone_counter++;
			} else {
				stone_counter = 0;
			}
			if (stone_counter == 8) {
				stone_counter = 0;
				// check initial board had 7 in a row
				for (y = 0; y < y_limit; y++) {
					if (initialB[1][y] == colourAI) {
						stone_counter++;
					}
				}
				if (stone_counter == 7) {
					return Rating.HAS_EIGHT_IN_A_ROW.getValue();
				}
			}
		}

		// search [width -1,y] for 8 in a row
		for (int y = 0; y < y_limit; y++) {
			if (board_to_assess[x_limit - 1][y] == colourAI) {
				stone_counter++;
			} else {
				stone_counter = 0;
			}
			if (stone_counter == 8) {
				stone_counter = 0;
				// check initial board had 7 in a row
				for (y = 0; y < y_limit; y++) {
					if (initialB[x_limit-1][y] == colourAI) {
						stone_counter++;
					}
				}
				if (stone_counter == 7) {
					return Rating.HAS_EIGHT_IN_A_ROW.getValue();
				}
			}
		}

		// search [x,1] for 8 in a row
		for (int x = 0; x < x_limit; x++) {
			if (board_to_assess[x][1] == colourAI) {
				stone_counter++;
			} else {
				stone_counter = 0;
			}
			if (stone_counter == 8) {
				stone_counter = 0;
				// check initial board had 7 in a row
				for (x = 0; x < x_limit; x++) {
					if (initialB[x][1] == colourAI) {
						stone_counter++;
					}
				}
				if (stone_counter == 7) {
					return Rating.HAS_EIGHT_IN_A_ROW.getValue();
				}
			}
		}

		// search [x, height -1] for 8 in a row
		for (int x = 0; x < x_limit; x++) {
			if (board_to_assess[x][y_limit - 1] == colourAI) {
				stone_counter++;
			} else {
				stone_counter = 0;
			}
			if (stone_counter == 8) {
				stone_counter = 0;
				// check initial board had 7 in a row
				for (x = 0; x < x_limit; x++) {
					if (initialB[x][y_limit - 1] == colourAI) {
						stone_counter++;
					}
				}
				if (stone_counter == 7) {
					return Rating.HAS_EIGHT_IN_A_ROW.getValue();
				}
			}
		}

		return 0;
	}
}
