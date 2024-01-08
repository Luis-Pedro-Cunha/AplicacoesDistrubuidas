package dados;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Exame implements Serializable {

        private static final long serialVersionUID = -3561763031527930720L;
        private LocalDateTime data;
        private String tipo;
        private String descricao;
        private String resultado;

        public Exame(){data = LocalDateTime.now();}

        public Exame(LocalDateTime data, String tipo, String descricao, String resultado){
            this.data = data;
            this.tipo = tipo;
            this.descricao = descricao;
            this.resultado = resultado;
        }

        public LocalDateTime getData() {
            return data;
        }

        public void setData(LocalDateTime data) {
            this.data = data;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getResultado() {
            return resultado;
        }

        public void setResultado(String resultado) {
            this.resultado = resultado;
        }

        @Override
        public String toString() {
            return "Exame\n-----------------\n" +
                    "Data " + data + " | " +
                    "Tipo: " + tipo + " | " +
                    "Descrição: " + descricao + " | " +
                    "Resultado: " + resultado;
        }
}

