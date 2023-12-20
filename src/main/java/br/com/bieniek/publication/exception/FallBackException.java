package br.com.bieniek.publication.exception;

public class FallBackException extends RuntimeException {

        public FallBackException(Throwable cause) {
            super("Estamos com problemas, tente novamente mais tarde.", cause);
        }
}
