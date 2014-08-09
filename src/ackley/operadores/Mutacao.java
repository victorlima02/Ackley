
package ackley.operadores;

import ackley.ambiente.Solucao;
import ic.ce.seres.binarios.mutadores.MutadorBinario;

/**
 *
 * @author Victor de Lima Soares
 */
public class Mutacao<S extends Solucao> extends MutadorBinario<S>{

    public Mutacao(double probabilidadeDeMutacao) {
        super(probabilidadeDeMutacao);
    }
    
}
