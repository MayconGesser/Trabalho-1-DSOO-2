/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import controladores.interfaces.IControladorPrincipal;
import javax.swing.JFrame;
import util.Util;

public abstract class Tela extends JFrame{
    
    protected final IControladorPrincipal controladorPrincipal;
    protected final Util util;
    
    public Tela(IControladorPrincipal controladorPrincipal){
        this.controladorPrincipal = controladorPrincipal;
        this.util = new Util();
    }
    
}
