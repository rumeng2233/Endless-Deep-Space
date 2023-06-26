package shirumengya.rumeng.reborn.endless_deep_space.custom.util.java.color;

public class RGBtoTen {
	
	public RGBtoTen() {
	}

	public int OutputResult (int r, int g, int b) {
		int result = (r * 256 * 256) + (g * 256) + b;
		return result;
	}
}
