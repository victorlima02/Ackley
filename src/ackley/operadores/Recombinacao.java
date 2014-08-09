/*
 * The MIT License
 *
 * Copyright 2014 Victor de Lima Soares.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ackley.operadores;

import ackley.ambiente.Solucao;
import ic.ce.base.Caracteristica;
import ic.ce.seres.binarios.recombinadores.RecombinadorBinario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor de Lima Soares
 */
public class Recombinacao extends RecombinadorBinario<Double,Solucao> {

    public Recombinacao( double probabilidadeDeRecombinacao) {
        super(probabilidadeDeRecombinacao, 2);
    }

    @Override
    public List<Solucao> recombina(List<Solucao> pares) {

        List<Solucao> filhos = new ArrayList<>(pares.size());

        Solucao f1 = getAlgoritmo().getGerador().get();
        Solucao f2 = getAlgoritmo().getGerador().get();
        Solucao p1 = pares.get(0);
        Solucao p2 = pares.get(1);

        List<List<Caracteristica>> crossx1 = onePointCrossover(p1.getCaracteristicas().subList(0, p1.getSize()/2 ), p2.getCaracteristicas().subList(0, p2.getSize()/2));
        List<List<Caracteristica>> crossx2 = onePointCrossover(p1.getCaracteristicas().subList(p1.getSize()/2, p1.getSize()), p2.getCaracteristicas().subList(p1.getSize()/2, p1.getSize()));

        f1.setCaracteristicas(0, crossx1.get(0));
        f1.setCaracteristicas(p1.getSize()/2, crossx2.get(0));
        filhos.add(f1);
        
        f2.setCaracteristicas(0, crossx1.get(1));
        f2.setCaracteristicas(p1.getSize()/2, crossx2.get(1));
        filhos.add(f2);

        return filhos;
    }

}
