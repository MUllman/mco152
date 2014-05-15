package ullman.mtamap;

public class Trip {

	private final String routeId;
	private final String shapeId;

	public Trip(String routeId, String shapeId) {
		this.routeId = routeId;
		this.shapeId = shapeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routeId == null) ? 0 : routeId.hashCode());
		result = prime * result + ((shapeId == null) ? 0 : shapeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Trip)) {
			return false;
		}
		Trip other = (Trip) obj;
		if (routeId == null) {
			if (other.routeId != null) {
				return false;
			}
		} else if (!routeId.equals(other.routeId)) {
			return false;
		}
		if (shapeId == null) {
			if (other.shapeId != null) {
				return false;
			}
		} else if (!shapeId.equals(other.shapeId)) {
			return false;
		}
		return true;
	}

	public String getRouteId() {
		return routeId;
	}

	public String getShapeId() {
		return shapeId;
	}
}
