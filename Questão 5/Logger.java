import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static volatile Logger instance;
    
    private PrintWriter arquivoWriter;
    private PrintWriter servidorWriter;
    
    private String arquivoLog = "sistema.log";
    private String servidorUrl = "http://monitoramento.empresa.com/api/logs";
    private boolean debugMode = false;
    
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    private Logger() {
        initialize();
    }
    
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    
    private void initialize() {
        try {
            arquivoWriter = new PrintWriter(new FileWriter(arquivoLog, true), true);
            System.out.println("Logger inicializado. Arquivo: " + arquivoLog);
            
        } catch (IOException e) {
            System.err.println("Erro ao inicializar logger: " + e.getMessage());
        }
    }
    
    public void log(String nivel, String mensagem, String modulo) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = String.format("[%s] %s - %s - %s", timestamp, nivel, modulo, mensagem);
        
        synchronized (this) {
            if (arquivoWriter != null) {
                arquivoWriter.println(logEntry);
            }
            
            enviarParaServidor(logEntry);
            
            if (debugMode) {
                System.out.println(logEntry);
            }
        }
    }
    
    public void info(String mensagem, String modulo) {
        log("INFO", mensagem, modulo);
    }
    
    public void erro(String mensagem, String modulo) {
        log("ERRO", mensagem, modulo);
    }
    
    public void warn(String mensagem, String modulo) {
        log("WARN", mensagem, modulo);
    }
    
    public void auditoria(String mensagem, String modulo) {
        log("AUDIT", mensagem, modulo);
    }
    
    private void enviarParaServidor(String logEntry) {
        if (debugMode) {
            System.out.println("Enviando para servidor: " + servidorUrl);
        }
    }
    
    public void setArquivoLog(String arquivo) {
        synchronized (this) {
            this.arquivoLog = arquivo;
            reinicializarWriter();
        }
    }
    
    public void setServidorUrl(String url) {
        this.servidorUrl = url;
    }
    
    public void setDebugMode(boolean debug) {
        this.debugMode = debug;
    }
    
    private void reinicializarWriter() {
        if (arquivoWriter != null) {
            arquivoWriter.close();
        }
        try {
            arquivoWriter = new PrintWriter(new FileWriter(arquivoLog, true), true);
        } catch (IOException e) {
            System.err.println("Erro ao reinicializar writer: " + e.getMessage());
        }
    }
    
    public void close() {
        synchronized (this) {
            if (arquivoWriter != null) {
                arquivoWriter.close();
                arquivoWriter = null;
            }
        }
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton não pode ser clonado");
    }
}