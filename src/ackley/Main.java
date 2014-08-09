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
package ackley;


import ackley.ambiente.FuncaoAckley;
import ackley.ambiente.PopulacaoDeSolucoes;
import ackley.operadores.Geracao;
import ackley.operadores.Mutacao;
import ackley.operadores.Recombinacao;
import ackley.operadores.Selecao;
import ic.ce.base.Ambiente;
import ic.ce.populacional.algoritmo.AlgoritmoPopulacional;
import ic.ce.base.algoritmo.operadores.Gerador;
import ic.ce.base.algoritmo.operadores.Mutador;
import ic.ce.populacional.algoritmo.operadores.Recombinador;
import ic.ce.populacional.algoritmo.operadores.Seletor;

/**
 *
 * @author Victor de Lima Soares
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){

        int maxIndividuos = 20;
        double probabilidaDeCruzamento = 1;        
        double probabilidadeDeMutacao = 0.1;
        
        Ambiente ambiente = new FuncaoAckley(20,0.2,2*Math.PI);
        PopulacaoDeSolucoes populacao = new PopulacaoDeSolucoes(ambiente, maxIndividuos);

        Gerador gerador = new Geracao();
        Mutador mutador = new Mutacao(probabilidadeDeMutacao);
        Recombinador recombinador = new Recombinacao(probabilidaDeCruzamento);
        Seletor seletor = new Selecao();
        
        populacao.setIndividuos(gerador.getNAleatorios(maxIndividuos));
        
        AlgoritmoPopulacional algoritmo = new Algoritmo();
            
        algoritmo.setAmbiente(ambiente);
        algoritmo.setPopulacao(populacao);
        
        algoritmo.setGerador(gerador);
        algoritmo.setMutador(mutador);
        algoritmo.setRecombinador(recombinador);
        algoritmo.setSeletor(seletor);
        
        algoritmo.run();
        
        System.out.println(algoritmo.relatorio());
    }

}
