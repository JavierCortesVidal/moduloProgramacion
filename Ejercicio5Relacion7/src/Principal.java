import java.util.Scanner;

public class Principal {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws PartidoException{
		boolean partidoCorrecto;
		
//Primer Partido
		try {
		Equipo equipoLocal1 = crearEquipo("local");
		Equipo equipoVisitante1 = crearEquipo("visitante");
		
		Partido partido1 = new Partido(equipoLocal1, equipoVisitante1, 1);
		partido1.ponerResultado("2-1");
		System.out.println(partido1.toString());
		}catch(PartidoException ex) {
			System.err.println(ex.getMessage());			
		}
//Segundo Partido	
		try {
		Equipo equipoLocal2 = crearEquipo("local");
		Equipo equipoVisitante2 = crearEquipo("visitante");
		Partido partido2 = new Partido(equipoLocal2, equipoVisitante2, 2);
		partido2.ponerResultado("0-0");
		System.out.println(partido2.toString());
		
		}catch(PartidoException ex) {
			System.err.println(ex.getMessage());
		}
		
//Tercer Partido
		try {
		Equipo equipoLocal3 = crearEquipo("local");
		Equipo equipoVisitante3 = crearEquipo("visitante");
		Partido partido3 = new Partido(equipoLocal3, equipoVisitante3, 3);
		partido3.ponerResultado("1-2");
		System.out.println(partido3.toString());
		}catch(PartidoException ex) {
			System.err.println(ex.getMessage());
		}
		
		

		
		
	}

	public static Equipo crearEquipo(String msg) {

		String nombreEquipo, nombreEstadio, ciudad;

		nombreEquipo = solicitarDatos("Introduce el nombre del equipo " + msg + ":");
		nombreEstadio = solicitarDatos("Introduce el nombre del estadio del equipo " + msg + ":");
		ciudad = solicitarDatos("Introduce el nombre de la ciudad del equipo  " + msg + ":");

		return new Equipo(nombreEquipo, nombreEstadio, ciudad);

	}

	public static String solicitarDatos(String msg) {

		String datoEquipo;
		System.out.println(msg);
		datoEquipo = teclado.nextLine();
		return datoEquipo;
	}

}
