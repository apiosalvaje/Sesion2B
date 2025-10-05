package pkg;

public class Empleado {
	
	public enum TipoEmpleado{Vendedor, Encargado};
	float salarioBase = 0;
	float primas = 0;
	float extras = 0;
	
	public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtras) {
		
		//determinar salario base
		if(tipo==TipoEmpleado.Encargado) {
			salarioBase = 2500;
		}else if(tipo==TipoEmpleado.Vendedor) {
			salarioBase = 2000;
		}
		
		//determinar las primas
		if(ventasMes>=1500) {
			primas = 200;
		}else if(ventasMes>=1000) {
			primas = 100;
		}
		
		//determinar extras
		extras = horasExtras * 30;
		
		return salarioBase + primas + extras;
	}
	
    public float calculoNominaNeta(float nominaBruta) {
    	
        float retencion = 0;

        if (nominaBruta >= 2500) {
            retencion = 0.18f;
        } else if (nominaBruta >= 2100) {
            retencion = 0.15f;
        }

        return nominaBruta * (1 - retencion);
    }
	

}
