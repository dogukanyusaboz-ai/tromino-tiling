public class TrominoTiling {
    private int[][] board;
    private int size;
    private int currentTileId = 1;

    public TrominoTiling(int n, int missingRow, int missingCol) {
        this.size = (int) Math.pow(2, n);
        this.board = new int[size][size];
        this.board[missingRow][missingCol] = -1;
        tile(size, 0, 0, missingRow, missingCol);
    }

    private void tile(int s, int topRow, int leftCol, int missRow, int missCol) {
        if (s == 1) return;

        int half = s / 2;
        int tileId = currentTileId++;

        int centerRowUpper = topRow + half - 1;
        int centerRowLower = topRow + half;
        int centerColLeft  = leftCol + half - 1;
        int centerColRight = leftCol + half;

        // 1. Sol Üst Çeyrek
        if (missRow < topRow + half && missCol < leftCol + half) {
            tile(half, topRow, leftCol, missRow, missCol);
        } else {
            board[centerRowUpper][centerColLeft] = tileId;
            tile(half, topRow, leftCol, centerRowUpper, centerColLeft);
        }

        // 2. Sağ Üst Çeyrek
        if (missRow < topRow + half && missCol >= leftCol + half) {
            tile(half, topRow, leftCol + half, missRow, missCol);
        } else {
            board[centerRowUpper][centerColRight] = tileId;
            tile(half, topRow, leftCol + half, centerRowUpper, centerColRight);
        }

        // 3. Sol Alt Çeyrek
        if (missRow >= topRow + half && missCol < leftCol + half) {
            tile(half, topRow + half, leftCol, missRow, missCol);
        } else {
            board[centerRowLower][centerColLeft] = tileId;
            tile(half, topRow + half, leftCol, centerRowLower, centerColLeft);
        }

        // 4. Sağ Alt Çeyrek
        if (missRow >= topRow + half && missCol >= leftCol + half) {
            tile(half, topRow + half, leftCol + half, missRow, missCol);
        } else {
            board[centerRowLower][centerColRight] = tileId;
            tile(half, topRow + half, leftCol + half, centerRowLower, centerColRight);
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }
}