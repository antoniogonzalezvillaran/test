package examenJAVA1412;

public class TresEnRaya {
	
	public static int X1=0, X2=0, X3=0, O1=0, O2=0, O3=0;
	public static int ficha=0,movimientoUsuarioNumero=0;
	public static boolean fichasSinMover=true;
	
	public static void main(String[] args) {
		boolean muevePrograma=false, mueveUsuario=false;
		boolean victoriaPrograma=false,victoriaUsuario=false;
		String movimientoUsuario=" "; 
		String partida="SI";
		System.out.println("Bienvenido al Tres en Raya"); 
		while(partida.equals("SI")) {
			imprimeTablero();
			while(fichasSinMover) {
				while(!mueveUsuario || movimientoUsuarioNumero==0 ) {
					System.out.println("¿Donde quieres poner una ficha?");
					movimientoUsuario=Entrada.cadena();
					mueveUsuario=convierteAPosicionMovimiento(movimientoUsuario,mueveUsuario);
				}
				mueveUsuario=false;
			
				while(!muevePrograma) {
					muevePrograma=mueveFichaAleatoria();
					usuarioMueveFicha();
				}
				muevePrograma=false;
				if(X1==0) {
					X1=ficha;
				}else {
					if (X2==0) { 
						X2=ficha;
					}else {
						if (X3==0) {
							X3=ficha;
						}
					}
				}
					imprimeTablero();
					fichasSinMover=quedanFichas();
		
			}
			victoriaPrograma=ganaPrograma();
			victoriaUsuario=ganaUsuario();
			if (!victoriaPrograma) {
				if (!victoriaUsuario) {
					System.out.println("Empate");
				}else {
					System.out.println("Ganaste");
				}
			}else {
				System.out.println("Gano el programa");
			}
			System.out.println("Quieres jugar de nuevo?(SI/NO)");
			partida=Entrada.cadena().toUpperCase();
			limpiarTablero();
			victoriaPrograma=false;
			victoriaUsuario=false;
		}
		System.out.println("Adios tenga un buen dia");
	}
	public static void imprimeTablero() {
		for (int posicion=1; posicion<10 ; posicion++) {
			if (posicion==X1 || posicion==X2 || posicion==X3 ) {
				System.out.print(" X ");
			}else {
				if (posicion==O1 || posicion==O2 || posicion==O3) {
					System.out.print(" O ");
				}else {
					System.out.print(" - ");
				}
			}
			if(posicion==3 || posicion==6 || posicion==9) {
				System.out.println("");
			}
		}
	}
	
	public static boolean mueveFichaAleatoria() {
		int numMax=9, numMin=1;
		ficha=(int)(Math.random()*(numMax-numMin+1)+numMin);
		if (ficha!=X1 &&ficha!=X2 &&ficha!=X3 &&ficha!=O1 &&ficha!=O2 && ficha!=O3) {
			return true;
		} else {
			return false;
		}
		
		
		
	}
	public static boolean quedanFichas() {
		if(X1==0 || X2==0 || X3==0 || O1==0 || O2==0 || O3==0) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean convierteAPosicionMovimiento(String movimientoUsuario, boolean mueveUsuario) {
		switch (movimientoUsuario.toUpperCase()) {
		case "ARRIBA IZQUIERDA":
			movimientoUsuarioNumero=1;
			break;
		case "ARRIBA CENTRO":
			movimientoUsuarioNumero=2;
			break;
		case "ARRIBA DERECHA":
			movimientoUsuarioNumero=3;
			break;
		case "CENTRO IZQUIERDA":
			movimientoUsuarioNumero=4;
			break;
		case "CENTRO CENTRO":
			movimientoUsuarioNumero=5;
			break;
		case "CENTRO DERECHA":
			movimientoUsuarioNumero=6;
			break;
		case "ABAJO IZQUIERDA":
			movimientoUsuarioNumero=7;
			break;
		case "ABAJO CENTRO":
			movimientoUsuarioNumero=8;
			break;
		case "ABAJO DERECHA":
			movimientoUsuarioNumero=9;
			break;
		default:
			movimientoUsuarioNumero=0;
			break;
		
		
		}
		if (movimientoUsuarioNumero!=X1 &&movimientoUsuarioNumero!=X2 &&movimientoUsuarioNumero!=X3 &&movimientoUsuarioNumero!=O1 &&movimientoUsuarioNumero!=O2 && movimientoUsuarioNumero!=O3) {
			return true;
		} else {
			return false;
		}
		
	}
	public static void usuarioMueveFicha() {
		if(O1==0) {
			O1=movimientoUsuarioNumero;
		}else {
			if (O2==0) { 
				O2=movimientoUsuarioNumero;
			}else {
				if (O3==0) {
					O3=movimientoUsuarioNumero;
				}
			}
		}
	}
	public static boolean ganaPrograma() {
		if(X1==1) {
			if ((X2==2 && X3==3)||(X2==3 && X3==2)||(X2==4 && X3==7)||(X2==7 && X3==4)||(X2==5 && X3==9)||(X2==9 && X3==5)) {
				return true;
			}
		}
		if(X2==1) {
			if ((X1==2 && X3==3)||(X1==3 && X3==2)||(X1==4 && X3==7)||(X1==7 && X3==4)||(X1==5 && X3==9)||(X1==9 && X3==5)) {
				return true;
			}
		}
		if(X3==1) {
			if ((X1==2 && X2==3)||(X1==3 && X2==2)||(X1==4 && X2==7)||(X1==7 && X2==4)||(X1==5 && X2==9)||(X1==9 && X2==5)) {
				return true;
			}
		}
		if(X1==5) {
			if ((X2==4 && X3==6)||(X2==6 && X3==4)||(X2==2 && X3==8)||(X2==8 && X3==2)) {
				return true;
			}
		}
		if(X2==5) {
			if ((X1==4 && X3==6)||(X1==6 && X3==4)||(X1==2 && X3==8)||(X1==8 && X3==2)) {
				return true;
			}
		}
		if(X3==5) {
			if ((X1==4 && X2==6)||(X1==6 && X2==4)||(X1==2 && X2==8)||(X1==8 && X2==2)) {
				return true;
			}
		}
		if(X1==9) {
			if ((X2==8 && X3==7)||(X2==7 && X3==8)||(X2==6 && X3==9)||(X2==9 && X3==6)) {
				return true;
			}
		}
		if(X2==9) {
			if ((X1==8 && X3==7)||(X1==7 && X3==8)||(X1==6 && X3==9)||(X1==9 && X3==6)) {
				return true;
			}
		}
		if(X3==9) {
			if ((X1==8 && X2==7)||(X1==7 && X2==8)||(X1==6 && X2==9)||(X1==9 && X2==6)) {
				return true;
			}
		}
		
		
		return false;
	}
	public static boolean ganaUsuario() {
		if(O1==1) {
			if ((O2==2 && O3==3)||(O2==3 && O3==2)||(O2==4 && O3==7)||(O2==7 && O3==4)||(O2==5 && O3==9)||(O2==9 && O3==5)) {
				return true;
			}
		}
		if(O2==1) {
			if ((O1==2 && O3==3)||(O1==3 && O3==2)||(O1==4 && O3==7)||(O1==7 && O3==4)||(O1==5 && O3==9)||(O1==9 && O3==5)) {
				return true;
			}
		}
		if(O3==1) {
			if ((O1==2 && O2==3)||(O1==3 && O2==2)||(O1==4 && O2==7)||(O1==7 && O2==4)||(O1==5 && O2==9)||(O1==9 && O2==5)) {
				return true;
			}
		}
		if(O1==5) {
			if ((O2==4 && O3==6)||(O2==6 && O3==4)||(O2==2 && O3==8)||(O2==8 && O3==2)) {
				return true;
			}
		}
		if(O2==5) {
			if ((O1==4 && O3==6)||(O1==6 && O3==4)||(O1==2 && O3==8)||(O1==8 && O3==2)) {
				return true;
			}
		}
		if(O3==5) {
			if ((O1==4 && O2==6)||(O1==6 && O2==4)||(O1==2 && O2==8)||(O1==8 && O2==2)) {
				return true;
			}
		}
		if(O1==9) {
			if ((O2==8 && O3==7)||(O2==7 && O3==8)||(O2==6 && O3==9)||(O2==9 && O3==6)) {
				return true;
			}
		}
		if(O2==9) {
			if ((O1==8 && O3==7)||(O1==7 && O3==8)||(O1==6 && O3==9)||(O1==9 && O3==6)) {
				return true;
			}
		}
		if(O3==9) {
			if ((O1==8 && O2==7)||(O1==7 && O2==8)||(O1==6 && O2==9)||(O1==9 && O2==6)) {
				return true;
			}
		}
		return false;
	}
	
	public static void limpiarTablero() {
		X1=0;
		X2=0;
		X3=0;
		O1=0;
		O2=0;
		O3=0;
		ficha=0;
		movimientoUsuarioNumero=0;
		fichasSinMover=true;
	}
}
