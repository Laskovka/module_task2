import java.util.Scanner;

public class Module {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Куда вы хотите поставить коня? Введите клетку(например: B3).");
        String horsePosition = scanner.nextLine();
        System.out.println("Отлично! Ваш конь попал на доску!");
        System.out.println("Позиция - " + horsePosition + ".");
        System.out.println("Куда вы хотите передвинуть коня? Введите клетку(например: B3).");
        String move = scanner.nextLine();
        System.out.println(moveHorse(findPositionOfHorse(chessBoard(), horsePosition), findPositionOfHorse(chessBoard(), move), chessBoard()));
    }

    public static String[][] chessBoard() {
        String[][] chessBoard = new String[][]{
                {"A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1"},
                {"A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2"},
                {"A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3"},
                {"A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4"},
                {"A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5"},
                {"A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6"},
                {"A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7"},
                {"A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8"}
        };
        return chessBoard;
    }

    public static int[] findPositionOfHorse(String[][] chessBoard, String horsePosition) {
        int[] returnedArray = new int[2];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j].equals(horsePosition)) {
                    returnedArray[0] = i;
                    returnedArray[1] = j;
                }
            }
        }
        return returnedArray;
    }

    public static String moveHorse(int[] currentPosition, int[] movePosition, String[][] chessBoard) {
        String movePositionDefined = chessBoard[movePosition[0]][movePosition[1]];
        String variant1 = "";
        String variant2 = "";
        String variant3 = "";
        String variant4 = "";
        String variant5 = "";
        String variant6 = "";
        String variant7 = "";
        String variant8 = "";
        if (currentPosition[0] - 1 >= 0) {
            if (currentPosition[0] - 2 >= 0) {
                if (currentPosition[1] - 1 >= 0) {
                    variant2 = chessBoard[currentPosition[0] - 2][currentPosition[1] - 1];
                }
                if (currentPosition[1] + 1 <= 7) {
                    variant1 = chessBoard[currentPosition[0] - 2][currentPosition[1] + 1];
                }
            } else {
                if (currentPosition[1] - 2 >= 0) {
                    variant6 = chessBoard[currentPosition[0] - 1][currentPosition[1] - 2];
                }
                if (currentPosition[1] + 2 <= 7) {
                    variant8 = chessBoard[currentPosition[0] - 1][currentPosition[1] + 2];
                }
            }
        }
        if (currentPosition[0] + 1 <= 7) {
            if (currentPosition[0] + 2 <= 7) {
                if (currentPosition[1] - 1 >= 0) {
                    variant4 = chessBoard[currentPosition[0] + 2][currentPosition[1] - 1];
                }
                if (currentPosition[1] + 1 <= 7) {
                    variant3 = chessBoard[currentPosition[0] + 2][currentPosition[1] + 1];
                }
            } else {
                if (currentPosition[1] - 2 >= 0) {
                    variant5 = chessBoard[currentPosition[0] + 1][currentPosition[1] - 2];
                }
                if (currentPosition[1] + 2 <= 7) {
                    variant7 = chessBoard[currentPosition[0] + 1][currentPosition[1] + 2];
                }
            }
        }

        if (movePositionDefined.equals(variant1) || movePositionDefined.equals(variant2) || movePositionDefined.equals(variant3) ||
                movePositionDefined.equals(variant4) || movePositionDefined.equals(variant5) || movePositionDefined.equals(variant6) ||
                movePositionDefined.equals(variant7) || movePositionDefined.equals(variant8)) {
            return "Теперь ваш конь находится на позиции " + movePositionDefined;
        } else {
            return "Коня переместить не удалось.";
        }
    }
}
