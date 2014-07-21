package dbScan;

public class point {

	private long id;
	private double longPonto, latPonto,  distPontoOrigem;
	private double longVertOrigem, latVertOrigem, longVertDestino, latVertDestino;
	
	point(long id, double longPonto, double latPonto,  double distPontoOrigem, double longVertOrigem, 
			double latVertOrigem,  double longVertDestino, double latVertDestino) {
		
		this.id = id;
		this.longPonto = longPonto;
		this.latPonto = latPonto;
		this.distPontoOrigem = distPontoOrigem;
		this.longVertOrigem = longVertOrigem;
		this.latVertOrigem = latVertOrigem;
		this.longVertDestino = longVertDestino;
		this.latVertDestino = latVertDestino;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getLongPonto() {
		return longPonto;
	}

	public void setLongPonto(double longPonto) {
		this.longPonto = longPonto;
	}

	public double getLatPonto() {
		return latPonto;
	}

	public void setLatPonto(double latPonto) {
		this.latPonto = latPonto;
	}

	public double getDistPontoOrigem() {
		return distPontoOrigem;
	}

	public void setDistPontoOrigem(double distPontoOrigem) {
		this.distPontoOrigem = distPontoOrigem;
	}

	public double getLongVertOrigem() {
		return longVertOrigem;
	}

	public void setLongVertOrigem(double longVertOrigem) {
		this.longVertOrigem = longVertOrigem;
	}

	public double getLatVertOrigem() {
		return latVertOrigem;
	}

	public void setLatVertOrigem(double latVertOrigem) {
		this.latVertOrigem = latVertOrigem;
	}

	public double getLongVertDestino() {
		return longVertDestino;
	}

	public void setLongVertDestino(double longVertDestino) {
		this.longVertDestino = longVertDestino;
	}

	public double getLatVertDestino() {
		return latVertDestino;
	}

	public void setLatVertDestino(double latVertDestino) {
		this.latVertDestino = latVertDestino;
	}
	
}
