package chess;

import java.util.Scanner;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("start : 게임 시작, end : 종료\n");
            final String command = scanner.next();
            final InputType type = InputType.match(command);
            if (type == InputType.start) {
                final Board board = new Board();
                final Board initBoard = board.initialize();
                initBoard.print();
            }
            if (type == InputType.Continue) {
                System.out.println("다시 입력해주세요.");
            }
            if (type == InputType.end) {
                break;
            }
        }
    }

    private enum InputType {
        start, end, Continue;

        private static InputType match(final String command) {
            return Stream.of(values())
                    .filter(type -> type.toString().equals(command))
                    .findFirst()
                    .orElse(Continue);
        }
    }
}
