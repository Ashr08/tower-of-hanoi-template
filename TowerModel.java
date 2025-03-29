public class TowerModel {

    private IntegerStack[] towers;
    private int towerHeight;
    private int moveCounter = 0;
    private int printCounter = 0;

    public TowerModel(int height) {
        towerHeight = height;
        towers = new IntegerStack[3];
        for (int t = 0; t < 3; t++) {
            towers[t] = new IntegerStack(height);
        }

        for (int i = 1; i <= height; i++) {
            towers[0].push(height - i + 1);
        }
    }

    public int getHeight() {
        return towerHeight;
    }

    public IntegerStack[] getTowers() {
        return towers;
    }

    public void move(int source, int destination) {
        System.out.println("Move #" + (++moveCounter) + " from " + source + " to " + destination);

        int topSource = towers[source].peek();
        int topDest = towers[destination].peek();

        if (topSource == 0) {
            return; // nothing to move
        }

        if (topDest == 0 || topSource < topDest) {
            towers[source].pop();
            towers[destination].push(topSource);
        }
    }

    public void print() {
        System.out.println("Print #" + (++printCounter) + " Current Towers");

        for (int level = towerHeight - 1; level >= 0; level--) {
            System.out.println();
            for (int col = 0; col < 3; col++) {
                int val = towers[col].get(level);
                if (val == 0) {
                    System.out.print(" |");
                } else {
                    System.out.print(" " + val);
                }
            }
        }

        System.out.println();
        System.out.println(" = = =");
    }
}