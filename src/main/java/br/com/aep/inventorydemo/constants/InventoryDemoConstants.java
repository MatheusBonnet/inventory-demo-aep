package br.com.aep.inventorydemo.constants;

public class InventoryDemoConstants {

    public static final String MESSAGE_ERROR = "Erro interno no servidor, consulte o suporte!!!";

    public static final String MESSAGE_ERROR_NOT_FOUND = "Nao encontrado, tente novamente.";

    public static final String MESSAGE_ERROR_REGISTER = "Erro ao salvar, tente novamente!";

    public InventoryDemoConstants() {
    }

    public static String getMessageError() {
        return MESSAGE_ERROR;
    }

    public static String getMessageErrorNotFound() {
        return MESSAGE_ERROR_NOT_FOUND;
    }

    public static String getMessageErrorRegister() {
        return MESSAGE_ERROR_REGISTER;
    }
}
