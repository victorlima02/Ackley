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

import ic.ce.populacional.Ambiente;

/**
 *
 * @author Victor de Lima Soares
 */
public class FuncaoAckley extends Ambiente<Double, Solucao> {

    double a, b, c;

    public FuncaoAckley(double a, double b, double c) {
        super(Modo.MINIMIZACAO);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Wolfram: evaluate (-20 * (exp(-0.2 * sqrt(0.5 * (x1 * x1 + x2 * x2)))) - exp(0.5 * (cos(2*PI * x1) + cos(2*PI * x2)))+20 + exp(1)) for x1 = 2147483647 , x2 = 1483891193 
    @Override
    public Double avalia(Solucao parX1X2) {

        double valor;
        long x1 = parX1X2.getX1();
        long x2 = parX1X2.getX2();

        valor = -a * (Math.exp(-b * Math.sqrt(0.5 * (x1 * x1 + x2 * x2))));
        valor += -Math.exp(0.5 * (Math.cos(c * x1) + Math.cos(c * x2)));
        valor += a + Math.E;

        return valor;
    }

}
