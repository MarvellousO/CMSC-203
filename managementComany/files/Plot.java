package managementComany;

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // Getter and setter methods for x, y, width, depth
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public boolean overlaps(Plot plot) {
        // Implement the logic to check if this plot overlaps with the given plot
    	// Return true if they overlap, false otherwise
    	// Determine if the current plot overlaps with the given plot
        // Two plots overlap if they share any common area
        int x1 = this.x;
        int y1 = this.y;
        int x2 = plot.getX();
        int y2 = plot.getY();
        int width1 = this.width;
        int height1 = this.depth;
        int width2 = plot.getWidth();
        int height2 = plot.getDepth();

        boolean xOverlap = x1 < x2 + width2 && x1 + width1 > x2;
        boolean yOverlap = y1 < y2 + height2 && y1 + height1 > y2;

        return xOverlap && yOverlap;
    }

    public boolean encompasses(Plot plot) {
        // Determine if the current plot encompasses the given plot (inclusive)
        int x1 = this.x;
        int y1 = this.y;
        int x2 = plot.getX();
        int y2 = plot.getY();
        int width1 = this.width;
        int height1 = this.depth;
        int width2 = plot.getWidth();
        int height2 = plot.getDepth();

        boolean xEncompasses = x1 <= x2 && x1 + width1 >= x2 + width2;
        boolean yEncompasses = y1 <= y2 && y1 + height1 >= y2 + height2;

        return xEncompasses && yEncompasses;
    }
    
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}