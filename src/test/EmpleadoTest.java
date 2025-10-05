package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {

	Empleado e = new Empleado();

    // TipoEmpleado - Encargado
    @Test
    void testTipoEmpleadoEncargado() {
        assertEquals(2500, e.calculoNominaBruta(TipoEmpleado.Encargado, 0f, 0f), 0.01);
    }

    // TipoEmpleado - Vendedor
    @Test
    void testTipoEmpleadoVendedor() {
        assertEquals(2000, e.calculoNominaBruta(TipoEmpleado.Vendedor, 0f, 0f), 0.01);
    }

    // TipoEmpleado - Otro
    @Test
    void testTipoEmpleadoOtro() {
        assertThrows(NullPointerException.class, () -> {
            e.calculoNominaBruta(null, 0f, 0f);
        });
    }

    // ventasMes - negativas
    @Test
    void testVentasMesNegativas() {
        assertEquals(2000, e.calculoNominaBruta(TipoEmpleado.Vendedor, -100f, 0f), 0.01);
    }

    // ventasMes - < 1000
    @Test
    void testVentasMesMenores1000() {
        assertEquals(2000, e.calculoNominaBruta(TipoEmpleado.Vendedor, 999f, 0f), 0.01);
    }

    // ventasMes - entre 1000 y 1500
    @Test
    void testVentasMesEntre1000Y1500() {
        assertEquals(2100, e.calculoNominaBruta(TipoEmpleado.Vendedor, 1200f, 0f), 0.01);
    }

    // ventasMes - > 1500
    @Test
    void testVentasMesMayor1500() {
        assertEquals(2200, e.calculoNominaBruta(TipoEmpleado.Vendedor, 1600f, 0f), 0.01);
    }

    // horasExtras - negativas
    @Test
    void testHorasExtrasNegativas() {
        assertEquals(2000 + (-5) * 30, e.calculoNominaBruta(TipoEmpleado.Vendedor, 0f, -5f), 0.01);
    }

    // horasExtras - < 200
    @Test
    void testHorasExtrasMenores200() {
        assertEquals(2000 + 150 * 30, e.calculoNominaBruta(TipoEmpleado.Vendedor, 0f, 150f), 0.01);
    }

    // horasExtras - > 200
    @Test
    void testHorasExtrasMayor200() {
        assertEquals(2000 + 201 * 30, e.calculoNominaBruta(TipoEmpleado.Vendedor, 0f, 201f), 0.01);
    }

    // nominaNeta - negativa
    @Test
    void testNominaNetaNegativa() {
        assertEquals(-100f, e.calculoNominaNeta(-100f), 0.01);
    }

    // nominaNeta - < 2100
    @Test
    void testNominaNetaMenor2100() {
        assertEquals(2099.99f, e.calculoNominaNeta(2099.99f), 0.01);
    }

    // nominaNeta - entre 2100 y 2500 (incluyendo los límites)
    @Test
    void testNominaNetaEntre2100() {
        assertEquals(2100 * (1 - 0.15f), e.calculoNominaNeta(2100f), 0.01);
    }

    @Test
    void testNominaNetaEntre2499_99() {
        assertEquals(2499.99f * (1 - 0.15f), e.calculoNominaNeta(2499.99f), 0.01);
    }

    // nominaNeta - > 2500
    @Test
    void testNominaNetaMayor2500() {
        assertEquals(3000 * (1 - 0.18f), e.calculoNominaNeta(3000f), 0.01);
    }

}
