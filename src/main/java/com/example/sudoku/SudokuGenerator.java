package com.example.sudoku;

import java.util.Random;

public class SudokuGenerator {

    private static final int GRID_SIZE = 9;

    private static final Random random = new Random();

    public int[][] generateSudoku() {
        int[][] grid = new int[GRID_SIZE][GRID_SIZE];
        fillSudoku(grid);
        return grid;
    }

    private boolean fillSudoku(int[][] grid) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col] == 0) {
                    int[] numbers = getRandomNumbers();
                    for (int number : numbers) {
                        if (isValid(grid, row, col, number)) {
                            grid[row][col] = number;
                            if (fillSudoku(grid)) {
                                return true;
                            } else {
                                grid[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public int getGridSize() {
        return GRID_SIZE;
    }

    private boolean isValid(int[][] grid, int row, int col, int number) {
        return !isInRow(grid, row, number) && !isInColumn(grid, col, number) && !isInBox(grid, row, col, number);
    }

    private boolean isInRow(int[][] grid, int row, int number) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (grid[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isInColumn(int[][] grid, int col, int number) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (grid[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBox(int[][] grid, int row, int col, int number) {
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[boxRow + i][boxCol + j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] getRandomNumbers() {
        int[] numbers = new int[GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            numbers[i] = i + 1;
        }
        for (int i = 0; i < GRID_SIZE; i++) {
            int randomIndex = random.nextInt(GRID_SIZE);
            int temp = numbers[i];
            numbers[i] = numbers[randomIndex];
            numbers[randomIndex] = temp;
        }
        return numbers;
    }

    public void removeElements(int[][] grid, int numRemove) {
        int count = 0;
        while (count <= numRemove) {
            System.out.println(count);
            int cellId = random.nextInt(GRID_SIZE * GRID_SIZE);
            int i = cellId / GRID_SIZE;
            int j = cellId % GRID_SIZE;
            if (grid[i][j] != 0) {
                count++;
                grid[i][j] = 0;
            }
        }
    }
}
