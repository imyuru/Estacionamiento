package proyecto2;


import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;


public class Principal {
	ArrayList <AutoMinuto> aM = new ArrayList<AutoMinuto>();
	ArrayList <Premium> pm = new ArrayList<Premium>();
	ArrayList <Vip> vi = new ArrayList<Vip>();
	private Scanner sc = new Scanner(System.in);
	String matriz[][] = new String[5][7];
	String espejo[][] = new String[5][7];
	int vip[] = new int[7];
	int premium[] = new int[7];
	private double recaudadoAM=0,recaudadoPM=0,recaudadoVIP=0;
	private double recaudadoAMD=0,recaudadoPMD=0,recaudadoVIPD=0;
	boolean again=true;

	public double getRecaudadoAM() {
		return recaudadoAM;
	}
	public void setRecaudadoAM(double recaudadoAM) {
		this.recaudadoAM = recaudadoAM;
	}
	public double getRecaudadoPM() {
		return recaudadoPM;
	}
	public void setRecaudadoPM(double recaudadoPM) {
		this.recaudadoPM = recaudadoPM;
	}
	public double getRecaudadoVIP() {
		return recaudadoVIP;
	}
	public void setRecaudadoVIP(double recaudadoVIP) {
		this.recaudadoVIP = recaudadoVIP;
	}
	public double getRecaudadoAMD() {
		return recaudadoAMD;
	}
	public void setRecaudadoAMD(double recaudadoAMD) {
		this.recaudadoAMD = recaudadoAMD;
	}
	public double getRecaudadoPMD() {
		return recaudadoPMD;
	}
	public void setRecaudadoPMD(double recaudadoPMD) {
		this.recaudadoPMD = recaudadoPMD;
	}
	public double getRecaudadoVIPD() {
		return recaudadoVIPD;
	}
	public void setRecaudadoVIPD(double recaudadoVIPD) {
		this.recaudadoVIPD = recaudadoVIPD;
	}
	public void retirar() {
		String pl,plan = "",letra="",d=" ocupado",ff="";
		int fila,num,min=0,dias=0,mes,op,op2,p=1,y=1;
		int v=0,v1=0,v2=0;
		sc.nextLine();
		System.out.println("Ingrese la placa del vehiculo");
		pl=sc.nextLine();
		
		
		 for(int x=0;x<aM.size();x++) {
			if(aM.get(x).getPlaca().equals(pl)) {
				v=v+1;
				System.out.println("Ingrese la cantidad de minutos que ha estado");
				min=sc.nextInt();
				if(aM.get(x).getCantidad()<=5) {
					System.out.println("Su plan es por minuto paga 0.5 centavos por minuto, total "+(0.5*min));
					setRecaudadoAMD(getRecaudadoAMD()+(0.5*min));
				}else {
					System.out.println("Su plan es por minuto paga 0.4 centavos por minuto, ha estado mas de 4 veces en el parqueadero, cliente frecuente, Total "+(0.5*min));
					setRecaudadoAMD(getRecaudadoAMD()+(0.4*min));
				}
				
					
				}
			}
		
		for(int x=0;x<pm.size();x++) {
			if(pm.get(x).getPlaca().equals(pl)) {
				v1=v+1;
				System.out.println("Ingrese la cantidad de dias que ha estado");
				min=sc.nextInt();
				System.out.println("Su plan es por dia paga 6.50 centavos por dia");
			    setRecaudadoPMD(getRecaudadoPMD()+(min*6.50));
			}
		}
		for(int x=0;x<vi.size();x++) {
			if(vi.get(x).getPlaca().equals(pl)) {
				v2=v+1;
				plan="vip";
				System.out.println("Su plan es por mes paga 100 dolares por mes");
				System.out.println("¿ha pasado un mes desde el ultimo pago?");
				System.out.println("1.Si");
				System.out.println("2.No");
				op=sc.nextInt();
				if(op==2) {
					System.out.println("Se le proporciona una tarjeta");
				}else {
					System.out.println("cuantos meses han pasado");
					op2=sc.nextInt();
					setRecaudadoVIPD(getRecaudadoVIPD()+(100*op2));
					System.out.println("Debe pagar : "+(100*op2));
					
				}
			}
		}
		if(v==0&&v1==0&&v2==0) {
			System.out.println("Su vehiculo no esta en el sistema.");
		}else if (v>0||v2>0||v1>0) {
			System.out.println("Donde está su vehiculo? Fila");
			System.out.println("1.A");
			System.out.println("2.B");
			System.out.println("3.C");
			System.out.println("4.D");
			System.out.println("5.E");
			fila=sc.nextInt();
			System.out.println("Alija la espacio 1-7");
			num=sc.nextInt();
			num=num-1;
			switch(fila) {
			case 1:
				letra = "A";
				matriz[0][num]=matriz[0][num].replace(" ocupado","");
				break;
			case 2:
				letra = "B";
				matriz[1][num]=matriz[0][num].replace(" ocupado","");
				break;
				
			case 3:
				letra = "C";
				matriz[2][num]=matriz[0][num].replace(" ocupado","");
				break;
				
			case 4:
				letra = "D";
				matriz[3][num]=matriz[0][num].replace(" ocupado","");
				break;
			case 5:
				letra = "E";
				matriz[4][num]=matriz[0][num].replace(" ocupado","");
				break;
			}
		}
		v=0;v1=0;v2=0;
		
		
	}
	public void registro() {
		String nombre,placa,numero,anio,modelo,marca;
		int apm1=0,op=0;
		again=true;
		while(again) {
			try {
				System.out.println("Menu de Registro");
				System.out.println("1. Auto por minuto");
				System.out.println("2. Auto Premium");
				System.out.println("3. Auto VIP");
				op=sc.nextInt();
				again=false;
			}catch (Exception ex) {
				System.out.println("Ingresa un numero");
				sc.next();
			}
			
		}
		
		switch(op){
		case 1:
			sc.nextLine();
			System.out.println("Menu de Autos por minuto");
			System.out.println("Ingrese la placa del vehiculo");
			placa=sc.nextLine();
			System.out.println("Ingrese el nombre del dueno");
			nombre=sc.nextLine();
			System.out.println("Ingrese el numero de contacto");
			numero=sc.nextLine();
			AutoMinuto am = new AutoMinuto();
			am.setPlaca(placa);
			am.setNombre(nombre);
			am.setNumero(numero);
			aM.add(am);
			break;
		case 2:
			sc.nextLine();
			System.out.println("Menu de autos premium (Por Mes)");
			System.out.println("Ingrese la placa del vehiculo");
			placa=sc.nextLine();
			System.out.println("Ingrese el nombre del dueno");
			nombre=sc.nextLine();
			System.out.println("Ingrese el numero de contacto");
			numero=sc.nextLine();
			Premium p = new Premium();
			p.setPlaca(placa);
			p.setNombre(nombre);
			p.setNumero(numero);
			pm.add(p);
			break;
		case 3:
			sc.nextLine();
			System.out.println("Menu de autos VIP");
			System.out.println("Ingrese la placa del vehiculo");
			placa=sc.nextLine();
			System.out.println("Ingrese el nombre del dueno");
			nombre=sc.nextLine();
			System.out.println("Ingrese el numero de contacto");
			numero=sc.nextLine();
			System.out.println("Ingrese la marca del auto");
			marca=sc.nextLine();
			System.out.println("Ingrese el modelo del auto");
			modelo=sc.nextLine();
			System.out.println("Ingrese el anio del auto");
			anio=sc.nextLine();
			Vip vip = new Vip();
			vip.setPlaca(placa);
			vip.setNombre(nombre);
			vip.setNumero(numero);
			vip.setMarca(marca);
			vip.setModelo(modelo);
			vip.setAnio(anio);
			vi.add(vip);
			break;
		}
		
	}
	public void ingresoAuto() {
		String pl,plan = "";
		int fila=0,num=0;
		int v=0,v1=0,v2=0;
		sc.nextLine();
		System.out.println("Ingrese la placa del vehiculo");
		pl=sc.nextLine();
		
		
		 for(int x=0;x<aM.size();x++) {
			if(aM.get(x).getPlaca().equals(pl)) {
				v=v+1;
				plan="Minuto";
				aM.get(x).setCantidad(aM.get(x).getCantidad()+1);
				if(aM.get(x).getCantidad()<=5) {
					System.out.println("Su plan es por minuto paga 0.5 centavos por minuto");
				}else {
					System.out.println("Su plan es por minuto paga 0.4 centavos");
				}
			}
		}
		for(int x=0;x<pm.size();x++) {
			if(pm.get(x).getPlaca().equals(pl)) {
				v1=v+1;
				plan="Premium";
				pm.get(x).setCantidad(pm.get(x).getCantidad()+1);
				System.out.println("Su plan es por dia paga 6.50 centavos por dia");
				
			}
		}
		for(int x=0;x<vi.size();x++) {
			if(vi.get(x).getPlaca().equals(pl)) {
				v2=v+1;
				plan="vip";
				vi.get(x).setCantidad(vi.get(x).getCantidad()+1);
				System.out.println("Su plan es por mes paga 100 dolares por mes");
			}
		}
		if(v==0&&v1==0&&v2==0) {
			System.out.println("Su vehiculo no esta registrado, enviando al registro");
			registro();
		}
		
		else if(v==1||v1==1||v2==1) {
			for (int x1=0; x1 < matriz.length; x1++) {
				  System.out.print("|");
				  for (int w=0; w < matriz[x1].length; w++) {
				    System.out.print (matriz[x1][w]);
				    if (w!=matriz[x1].length-1) System.out.print("\t");
				  }
				  System.out.println("|");
				}
			again=true;
			while (again) {
				try {
					System.out.println("Alija la fila (Horizontal)");
					System.out.println("1.A");
					System.out.println("2.B");
					System.out.println("3.C");
					System.out.println("4.D");
					System.out.println("5.E");
					fila=sc.nextInt();
					again=false;
				}catch(InputMismatchException e){
					   System.out.println("ERROR INGRESAR UN NUMERO");
					   sc.next();
					   
				   }
			}
		again=true;
		while(again) {
			try {
				System.out.println("Alija la espacio 1-7");
				num=sc.nextInt();
				again=false;
			}catch(InputMismatchException e){
				   System.out.println("ERROR INGRESAR UN NUMERO ");
				   sc.next();
				   
			   }
		}
		
			
			num=num-1;
			switch(fila) {
			case 1:
				matriz[0][num]=matriz[0][num]+" ocupado";
				espejo[0][num]=pl;
				break;
			case 2:
				matriz[1][num]=matriz[1][num]+" ocupado";
				espejo[1][num]=pl;
				break;
				
			case 3:
				matriz[2][num]=matriz[2][num]+" ocupado";
				espejo[2][num]=pl;
				break;
				
			case 4:
				matriz[3][num]=matriz[3][num]+" ocupado";
				espejo[3][num]=pl;
				break;
			case 5:
				matriz[4][num]=matriz[4][num]+" ocupado";
				espejo[4][num]=pl;
				break;
			}
			
		}
		v=0;
		v1=0;
		v2=0;
		plan="";
		}
	
	public void configuracion() {
		int op=0, s=0,p=1,y=1,j=0,columna = 0,f=0,d=0;
		sc.nextLine();
		for (int x=0; x < matriz.length; x++) {
			  System.out.print("|");
			  for (int w=0; w < matriz[x].length; w++) {
			    System.out.print (matriz[x][w]);
			    if (w!=matriz[x].length-1) System.out.print("\t");
			  }
			  System.out.println("|");
			}
		again=true;
		while (again) {
			try {
				System.out.println("Ingrese el tipo de que quiere modificar");
				System.out.println("1.Premium");
				System.out.println("2.VIP");
				op=sc.nextInt();
				again=false;
			}catch(InputMismatchException e){
				   System.out.println("ERROR INGRESAR UN NUMERO ");
				   sc.next();
				   
			 }
			
		}
		
		
		switch(op) {
		case 1:
			again=true;
			while(again){
				try {
					System.out.println("Ingrese la columna que quiere setear como Premium");
					columna=sc.nextInt();
					again=false;
				}catch(InputMismatchException e){
					   System.out.println("ERROR INGRESAR UN NUMERO ");
					   sc.next();
					   
				 }
			}
			
			columna=columna-1;
			for(int w=0; w<5; w++) {
				matriz[w][columna]=matriz[w][columna]+" Premium";
			}
			premium[f]=columna-1;
			f=f+1;
			break;
		case 2: 
			again=true;
			while(again) {
				try {
					System.out.println("Ingrese la columna que quiere setear como Vip");
					columna=sc.nextInt();
					again=false;
				}catch(InputMismatchException e){
					   System.out.println("ERROR INGRESAR UN NUMERO ");
					   sc.next();
				 }
				
			}
			
			columna=columna-1;
			for(int w=0; w<5; w++) {
				matriz[w][columna]=matriz[w][columna]+" VIP";
			}
			vip[d]=columna-1;
			d=d+1;
			break;
		}
	}
	public void disponibilidad() {
		int op = 0;
		for (int x=0; x < matriz.length; x++) {
			  System.out.print("|");
			  for (int w=0; w < matriz[x].length; w++) {
			    System.out.print (matriz[x][w]);
			    if (w!=matriz[x].length-1) System.out.print("\t");
			  }
			  System.out.println("|");
			}
		again=true;
		while (again) {
			try {
				System.out.println("¿Desea agregar ingresar un vehiculo? 1.Si 2.No");
				op=sc.nextInt();
				again=false;
			}catch(InputMismatchException e){
				   System.out.println("Ingrese un numero");
				   sc.next();
				   
			}
		}
		
		if(op==1) {
			ingresoAuto();
		}
	}
	public void ingreso() {
		int op=0, s=0,p=1,y=1;
		for(int i=0; i<5; i++) {
			for(int j=0;j<7;j++) {
				if(p==1) {
					matriz[i][j]="A"+Integer.toString(y);
					y=y+1;
				}
				if(p==2) {
					matriz[i][j]="B"+Integer.toString(y);
					y=y+1;
				}
				if(p==3) {
					matriz[i][j]="C"+Integer.toString(y);
					y=y+1;
				}
				if(p==4) {
					matriz[i][j]="D"+Integer.toString(y);
					y=y+1;
				}
				if(p==5) {
					matriz[i][j]="E"+Integer.toString(y);
					y=y+1;
				}
			}
			y=1;
			p=p+1;
		}
	
		while(s!=1) {
		System.out.println("Bienvenido al sistema de estacionamiento");
		System.out.println("1. Configurar matriz");
		System.out.println("2. Verificar disponibilidad");
		System.out.println("3. Retirar un vehiculo");
		System.out.println("4. Registro de vehiculo");
		System.out.println("5. Vehiculos registrados");
		System.out.println("6. Cierre de caja ");
		System.out.println("7. Monto total ");
		System.out.println("8. Salir");
		again=true;
		do {
			   try {
					  
				   System.out.println("Elija una opcion: ");
					op=sc.nextInt();
					if(op!=1&&op!=2&&op!=3&&op!=4&&op!=5&&op!=6&&op!=7&&op!=8) {
						System.out.println("El valor que ingresó esta fuera del rango");
					}
			   }catch(InputMismatchException e){
				   System.out.println("Ingrese un numero");
				   sc.next();
				   
			   }
			
		}while(op!=1&&op!=2&&op!=3&&op!=4&&op!=5&&op!=6&&op!=7&&op!=8);
		switch(op) {
		case 1:
			configuracion();
			break;
		case 2:
			disponibilidad();
			break;
		case 3:
			retirar();
			break;
		case 4:
			registro();
			break;
		case 5:
			System.out.println("Autos por minuto");
			for(int x=0;x<aM.size();x++) {
				System.out.println("Placa del vehiculo "+aM.get(x).getPlaca());
				System.out.println("Nombre del duenio "+aM.get(x).getNombre());
				System.out.println("Numero de contacto "+aM.get(x).getNumero());
			}
			System.out.println("Autos Premium");
			for(int x=0;x<pm.size();x++) {
				System.out.println("Placa del vehiculo "+pm.get(x).getPlaca());
				System.out.println("Nombre del duenio "+pm.get(x).getNombre());
				System.out.println("Numero de contacto "+pm.get(x).getNumero());
			}
			System.out.println("Autos Vip");
			for(int x=0;x<pm.size();x++) {
				System.out.println("Placa del vehiculo "+vi.get(x).getPlaca());
				System.out.println("Nombre del duenio "+vi.get(x).getNombre());
				System.out.println("Numero de contacto "+vi.get(x).getNumero());
				System.out.println("Modelo "+vi.get(x).getModelo());
				System.out.println("Anio "+vi.get(x).getAnio());
				System.out.println("Marca "+vi.get(x).getMarca());
			}
			break;
		case 6:
			System.out.println("CERRANDO CAJA GANANCIAS DEL DIA");
			System.out.println("Ganancias por autos por minuto: "+getRecaudadoAMD());
			System.out.println("Ganancias por autos por dia (Premium): "+getRecaudadoPMD());
			System.out.println("Ganancias por autos por mes (VIP): "+getRecaudadoVIPD());
			setRecaudadoAM(getRecaudadoAM()+getRecaudadoAMD());
			setRecaudadoPM(getRecaudadoPM()+getRecaudadoPMD());
			setRecaudadoPM(getRecaudadoVIP()+getRecaudadoVIPD());
			setRecaudadoAMD(0);
			setRecaudadoPMD(0);
			setRecaudadoVIPD(0);
			break;
		case 7:
			System.out.println("CERRANDO CAJA GANANCIAS TOTALES");
			System.out.println("Ganancias por autos por minuto: "+getRecaudadoAM());
			System.out.println("Ganancias por autos por dia (Premium): "+getRecaudadoPM());
			System.out.println("Ganancias por autos por mes (VIP): "+getRecaudadoVIP());
			break;
		case 8:
			s=1;
			break;
		}
		}
	}

	public static void main(String[] args) {
		Principal p=new Principal();
		p.ingreso();

	}

}
