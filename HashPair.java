
@SuppressWarnings("hiding") //added this because the IDE suggested it.
public class HashPair<locationKey, WorldObject> {
	private locationKey key;
	private WorldObject value;
	
	public HashPair(locationKey key, WorldObject value) {
		this.key = key;
		this.value = value;
	}
	
	public locationKey getKey() {
		return this.key;
	}
	
	public WorldObject getValue() {
		return this.value;
	}
	
	public void setValue(WorldObject value) {
		this.value = value;
	}
}
