
public class Partido {

	private int jornada, golesLocal, golesVisitante;
	Equipo equipoLocal, equipoVisitante;
	private boolean jugado;
	public static final int JORNADA_MINIMA = 1, JORNADA_MAXIMA = 38;
	private char resultado;
	public static final char GANADOR_LOCAL = '1', GANADOR_VISITANTE = '2', EMPATE = 'X';

	public Partido(Equipo equipoLocal, Equipo equipoVisitante, int jornada) throws PartidoException {

		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.jornada = jornada;

		if (equipoLocal.equals(equipoVisitante) == true ) {

			throw new PartidoException("Ambos equipos son el mismo");// Exception
		}
		if (jornada<JORNADA_MINIMA || jornada>JORNADA_MAXIMA) {
			
			throw new PartidoException("Error jornada");
		}
	}

	public int getJornada() {
		return jornada;

	}

	public int getGolesLocal() throws PartidoException {

		if (jugado == false) {
			throw new PartidoException("No hay goles del local debido a que no se ha jugado el partido");
		}
		return golesLocal;
	}

	public int getGolesVisitante() throws PartidoException {

		if (jugado == false) {
			throw new PartidoException("No hay goles del visitante debido a que no se ha jugado el partido");
		}
		return golesVisitante;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public boolean isJugado() {
		return jugado;

	}

	public char getResultado() {
		return resultado;

	}

	@Override
	public String toString() {

		String mensaje;

		if (jugado == false) {
			mensaje = "Partido entre equipo local " + equipoLocal.getNombreEquipo() + " y equipo visitante " + equipoVisitante.getNombreEquipo()
					+ " todavia no se ha jugado";
		} else {
			mensaje = "Partido entre equipo local " + equipoLocal.getNombreEquipo() + " y equipo visitante " + equipoVisitante.getNombreEquipo()
					+ " jugado en el estadio " + equipoLocal.getNombreEstadio() + " de la ciudad "
					+ equipoLocal.getCiudad() + " ha finalizado con " + golesLocal + " goles de equipo local y "
					+ golesVisitante + " goles de equipo visitante. Resultado de la quiniela= " + resultado;
		}
		return mensaje;
	}

	public void ponerResultado(String resultado) throws PartidoException {

		int posicion;

		posicion = resultado.indexOf("-");
		golesLocal = Integer.parseInt(resultado.substring(0, posicion));
		golesVisitante = Integer.parseInt(resultado.substring(posicion + 1, resultado.length()));

		if (golesLocal < 0 || golesVisitante < 0) {
			throw new NumberFormatException("Error al introducir los goles"); //
		} else {

			jugado = true;
		}
		if (golesLocal > golesVisitante) {
			equipoLocal.incrementarPartidosGanados();
			this.resultado = GANADOR_LOCAL;
			

		} else {
			if (golesLocal < golesVisitante) {
				equipoVisitante.incrementarPartidosGanados();
				this.resultado = GANADOR_VISITANTE;
				
			} else {
				this.resultado = EMPATE;
				
			}
		}
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}

}
