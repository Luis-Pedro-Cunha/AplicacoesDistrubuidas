package dados;

import java.io.Serializable;
import java.time.LocalDate;

public class Medicao implements Serializable {

    private static final long serialVersionUID = -8180529343441525793L;
    private LocalDate data;

        private double peso, altura;

        private int tensao_arterial, saturacao_oxigenio, imc;


        public Medicao() {
            data = LocalDate.now();
        }


        public Medicao(LocalDate data, double peso, double altura, int tensao_arterial, int saturacao_oxigenio, int imc) {

            this.data = data;
            this.peso = peso;
            this.altura = altura;
            this.tensao_arterial = tensao_arterial;
            this.saturacao_oxigenio = saturacao_oxigenio;
            this.imc = imc;
        }

        public double getPeso() {
            return peso;
        }

        public void setPeso(double peso) {
            this.peso = peso;
        }

        public double getAltura() {
            return altura;
        }

        public void setAltura(double altura) {
            this.altura = altura;
        }

        public int getTensao_arterial() {
            return tensao_arterial;
        }

        public void setTensao_arterial(int tensao_arterial) {
            this.tensao_arterial = tensao_arterial;
        }

        public int getSaturacao_oxigenio() {
            return saturacao_oxigenio;
        }

        public void setSaturacao_oxigenio(int saturacao_oxigenio) {
            this.saturacao_oxigenio = saturacao_oxigenio;
        }

        public int getImc() {
            return imc;
        }

        public void setImc(int imc) {
            this.imc = imc;
        }

        @Override
        public String toString() {
            return "Medições\n------------------\n" +
                    "Data: " + data + " | " +
                    "Peso: " + peso + " | " +
                    "Altura: " + altura + " | " +
                    "Tensão Arterial: " + tensao_arterial + " | " +
                    "Saturação de oxigénio: " + saturacao_oxigenio + " | " +
                    "IMC: " + imc;
        }
    }
