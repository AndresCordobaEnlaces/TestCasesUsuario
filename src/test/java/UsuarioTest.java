import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import io.github.mperedrii.Usuario;

public class UsuarioTest {

    @Test
    void registro_CE1_CE5_CE8_CE20_valido() {
        Usuario usuario = new Usuario("Tomate", "Password1", 19, "usuario@gmail.com");
        assertTrue(usuario.validarRegistro(), "El registro debería ser válido con todos los campos correctos.");
    }

    @Test
    void usuario_CE2_longitudMenor5() {
        Usuario usuario = new Usuario("Toma", "Password1", 19, "usuario@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por usuario menor a 5 caracteres.");
    }

    @Test
    void usuario_CE3_longitudMayor15() {
        Usuario usuario = new Usuario("UnUsuarioDemasiadoLargo", "Password1", 19, "usuario@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por usuario mayor a 15 caracteres.");
    }

    @Test
    void usuario_CE4_nulo() {
        Usuario usuario = new Usuario(null, "Password1", 19, "usuario@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por usuario nulo.");
    }

    @Test
    void edad_CE6_menor18() {
        Usuario usuario = new Usuario("Tomate", "Password1", 17, "usuario@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por edad menor de 18.");
    }

    @Test
    void edad_CE7_negativa() {
        Usuario usuario = new Usuario("Tomate", "Password1", -5, "usuario@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por edad negativa.");
    }

    @Test
    void correo_CE9_terminaEnArroba() {
        Usuario usuario = new Usuario("Tomate", "Password1", 19, "usuario@");
        assertFalse(usuario.validarRegistro(), "Debe fallar por correo terminado en @.");
    }

    @Test
    void correo_CE10_sinPuntoEnDominio() {
        Usuario usuario = new Usuario("Tomate", "Password1", 19, "usuario@gmail");
        assertFalse(usuario.validarRegistro(), "Debe fallar por correo sin punto en el dominio.");
    }

    @Test
    void correo_CE11_sinDominioAntesDelPunto() {
        Usuario usuario = new Usuario("Tomate", "Password1", 19, "usuario@.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por correo sin dominio antes del punto.");
    }

    @Test
    void correo_CE12_sinArroba() {
        Usuario usuario = new Usuario("Tomate", "Password1", 19, "usuariogmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por correo sin @.");
    }

    @Test
    void correo_CE13_soloArroba() {
        Usuario usuario = new Usuario("Tomate", "Password1", 19, "@");
        assertFalse(usuario.validarRegistro(), "Debe fallar por correo formado solo por @.");
    }

    @Test
    void correo_CE14_sinUsuarioAntesDeArroba() {
        Usuario usuario = new Usuario("Tomate", "Password1", 19, "@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por correo sin usuario antes de @.");
    }

    @Test
    void correo_CE15_soloTexto() {
        Usuario usuario = new Usuario("Tomate", "Password1", 19, "usuariogmailcom");
        assertFalse(usuario.validarRegistro(), "Debe fallar por correo solo texto.");
    }

    @Test
    void correo_CE16_conPuntoPeroSinArroba() {
        Usuario usuario = new Usuario("Tomate", "Password1", 19, "usuario.gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por correo con punto pero sin @.");
    }

    @Test
    void correo_CE17_dominioSinUsuarioNiArroba() {
        Usuario usuario = new Usuario("Tomate", "Password1", 19, "gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por correo con dominio pero sin usuario ni @.");
    }

    @Test
    void correo_CE18_soloExtension() {
        Usuario usuario = new Usuario("Tomate", "Password1", 19, ".com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por correo con solo la extensión.");
    }

    @Test
    void correo_CE19_nulo() {
        Usuario usuario = new Usuario("Tomate", "Password1", 19, null);
        assertFalse(usuario.validarRegistro(), "Debe fallar por correo nulo.");
    }

    @Test
    void contrasena_CE21_longitudMenor8() {
        Usuario usuario = new Usuario("Tomate", "Passw1", 19, "usuario@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por contraseña menor a 8 caracteres.");
    }

    @Test
    void contrasena_CE22_longitudMayor20() {
        Usuario usuario = new Usuario("Tomate", "PasswordMuyLarga12345678", 19, "usuario@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por contraseña mayor a 20 caracteres.");
    }

    @Test
    void contrasena_CE23_caracterNoAlfanumerico() {
        Usuario usuario = new Usuario("Tomate", "Password1-", 19, "usuario@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por contraseña con carácter no alfanumérico.");
    }

    @Test
    void contrasena_CE24_sinMayusculas() {
        Usuario usuario = new Usuario("Tomate", "password123", 19, "usuario@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por contraseña sin mayúsculas.");
    }

    @Test
    void contrasena_CE25_sinMinusculas() {
        Usuario usuario = new Usuario("Tomate", "PASSWORD123", 19, "usuario@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por contraseña sin minúsculas.");
    }

    @Test
    void contrasena_CE26_sinNumeros() {
        Usuario usuario = new Usuario("Tomate", "PasswordTest", 19, "usuario@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por contraseña sin números.");
    }

    @Test
    void contrasena_CE27_nula() {
        Usuario usuario = new Usuario("Tomate", null, 19, "usuario@gmail.com");
        assertFalse(usuario.validarRegistro(), "Debe fallar por contraseña nula.");
    }
}
