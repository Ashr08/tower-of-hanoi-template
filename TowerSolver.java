public class TowerSolver {

    private TowerModel modelRef;

    public TowerSolver() {
        // no-op
    }

    public void solve(TowerModel model) {
        modelRef = model;
        solve(model.getHeight(), 0, 2, 1);
    }

    private void solve(int numDisks, int start, int end, int temp) {
        if (numDisks < 1) return;

        solve(numDisks - 1, start, temp, end);
        modelRef.move(start, end);
        solve(numDisks - 1, temp, end, start);
    }
}
