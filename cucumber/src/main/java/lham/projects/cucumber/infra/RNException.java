package lham.projects.cucumber.infra;


/**
 * Exce��o padr�o de regra de neg�cio. Deve ser a super classe
 * das exce��es espec�ficas de regras de neg�cio da aplica��o (quando existirem).<br><br>
 * 
 * � uma RuntimeException, portanto n�o precisa ser tratada. <br><br> 
 * 
 * A primeira camada se encarrega de mostrar uma mensagem para o usu�rio.   
 *  
 * @author mauro-flores
 *
 */
public class RNException extends RuntimeException {
  protected static String  tagInicial       = "<RNException>";

  protected static String  tagFinal         = "</RNException>";

  protected static String  tagMsgInicial    = "<msg>";

  protected static String  tagMsgFinal      = "</msg>";

  protected static String  tagCampoInicial  = "<campo>";

  protected static String  tagCampoFinal    = "</campo>";

  protected static String  separador        = "|";

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  String[]                  campos;

  String[]                  mensagens;

  public RNException(String msg) {
    super(msg);
    mensagens = new String[] { msg };
    campos = new String[] { null };
  }

  public RNException(String msg, String pcampo) {
    super(msg);    
    campos = new String[] { pcampo };
    mensagens = new String[] { msg };
  }

  public RNException(String[] msg) {
    super(msg[0]);
    mensagens = msg;
    campos = new String[mensagens.length];
  }

  public RNException(String[] msg, String[] pcampo) {
    super(msg[0]);
    campos = pcampo;
    mensagens = msg;
  }

  public String getCampo() {
    return campos[0];
  }

  public String[] getCampos() {
    return campos;
  }

  public String[] getMensagens() {
    return mensagens;
  }

  /**
   * Ver documenta��o do m�todo recriar 
   * @return
   */
  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer(super.toString());
    sb.append("\n");
    sb.append(tagInicial);
    sb.append(tagMsgInicial);
    if (mensagens != null) {
      for (int i = 0; i < mensagens.length; i++) {
        if (mensagens[i] == null) {
          continue;
        }
        if (i > 0) {
          sb.append(separador);
        }
        sb.append(mensagens[i]);
      }
    }
    sb.append(tagMsgFinal);
    sb.append(tagCampoInicial);
    if (campos != null) {
      for (int i = 0; i < campos.length; i++) {
        if (campos[i] == null) {
          continue;
        }
        if (i > 0) {
          sb.append(separador);
        }
        sb.append(campos[i]);
      }
    }
    sb.append(tagCampoFinal);
    sb.append(tagFinal);
    return sb.toString();
  }

  /**
   * M�todo criado para obter uma RNException a partir do conte�do gerado pelo toString.
   * Esta op��o foi criada porque foi identificado que quando � gerada uma EJBTransactionRolledbackException a RNException 
   * que gerou n�o fica armazenada nas causas, apenas como texto da mensagem. Foi criado uma padr�o para armazenar no toString
   * da RNException as propriedades especifica da mesma.  
   * @param str
   * @return
   */
  public static RNException recriar(String str) {
    int pInicial = str.indexOf(tagInicial);
    if (pInicial < 0) {
      return null;
    }
    int pFinal = str.indexOf(tagFinal, pInicial);
    if (pFinal < 0) {
      return null;
    }
    String rnMensagens[] = null;
    String rnCampos[] = null;
    int pInicialMsg = str.indexOf(tagMsgInicial, pInicial);
    if (pInicialMsg > 0) {
      pInicialMsg += tagMsgInicial.length();
      int pFinalMsg = str.indexOf(tagMsgFinal, pInicialMsg);
      String msg = str.substring(pInicialMsg, pFinalMsg);
      rnMensagens = msg.split("\\" + separador);
    }
    int pInicialCampo = str.indexOf(tagCampoInicial, pInicial);
    if (pInicialCampo > 0) {
      pInicialCampo += tagCampoInicial.length();
      int pFinalCampo = str.indexOf(tagCampoFinal, pInicialCampo);
      String campo = str.substring(pInicialCampo, pFinalCampo);
      rnCampos = campo.split("\\" + separador);
    }
    return new RNException(rnMensagens, rnCampos);
  }
}