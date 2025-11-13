package assignment_4;

public class Plot {

	/**
	 * @field: int x
	 * @field: int y
	 * @field: depth
	 * @field: width
	 * 
	 */
	private int x;
	private int y;
	private int depth;
	private int width;
	

	/**
	 * No arg constructor 
	 */
	public Plot() {this.x = 0;
					this.y = 0;
					this.width = 0;
					this.depth = 0;}
	
	/**
	 * Constructor with only coordinates (x,y) to the plot
	 * @param x
	 * @param y
	 */
	public Plot(int x, int y) 
	{
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.depth = 0;
	}
	
	
	/**
	 * Constructor with all arguments (x,y,width,depth) to the plot
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Plot(int x, int y, int width, int depth) 
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	
	/**
	 * Create a new plot given another plot
	 * @param otherPlot
	 */
	public Plot(Plot otherPlot) 
	{
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}

	
	// Accessors 
	/**
	 * 
	 * @return x
	 */
	public int getX() {return this.x;}
	
	/**
	 * 
	 * @return y
	 */
	public int getY() {return this.y;}
	
	/**
	 * 
	 * @return width
	 */
	public int getWidth() {return this.width;}
	
	/**
	 * 
	 * @return depth
	 */
	public int getDepth() {return this.depth;}
	
	
	// Mutators
	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {this.x = x;}
	
	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {this.y = y;}
	
	/**
	 * 
	 * @param width
	 */
	public void setWidth(int width) {this.width = width;}
	
	/**
	 * 
	 * @param depth
	 */
	public void setDepth(int depth) {this.depth = depth;}
	
	
	//Methods
	/**
	 * 
	 * if the current plot contains it
	 * @param plot
	 * @return true -> if the current plot contains other plot
	 */
	public boolean overlaps(Plot plot) 
	{
		if(this.x + this.width <= plot.x ||
		   plot.x + plot.width <= this.x || 
		   this.y + this.depth <= plot.y ||
		   plot.y + plot.depth <= this.y) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param plot
	 * @return true -> if plot encompasses other plots
	 */
	public boolean encompasses(Plot plot) 
	{
		if(this.x <= plot.x &&
			this.y <= plot.y &&
			this.x + this.width >= plot.x + plot.width &&
			this.y + this.depth >= plot.y + plot.depth) {
			return true;
			}
		return false;
	}
		

	@Override
	/**
	 * @return attributes of the plot
	 */
	public String toString() {return (String) (this.x + "," + this.y +
							","+this.width + ","+this.depth);}
}
