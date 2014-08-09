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
package ackley.ambiente;


import ic.ce.seres.binarios.SerBinario;

/**
 *
 * @author Victor de Lima Soares
 */
public class Solucao extends SerBinario<Double> {

    public static final int nBitPorVariavel = 8;
    /**
     * Construtor do Ser: <code>Solucao</code>.
     *
     * Ser com oito características. Tamanho fixo: true.
     * <ul>
     * <li>32 bits para x1;</li>
     * <li>32 bits para x2.</li>
     * </ul>
     */
    public Solucao() {
        super(nBitPorVariavel*2);
    }

    public int getX1() {

        return locusBinarios2Int(getCaracteristicas().subList(0, nBitPorVariavel));
    }

    public int getX2() {

        return locusBinarios2Int(getCaracteristicas().subList(nBitPorVariavel, nBitPorVariavel*2));
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append("[ ");

        print.append(super.toString());

        print.append(" -> ");
        print.append("( "+getX1()+" , "+getX2()+" )");
        print.append("]");
        return print.toString();
    }
}
