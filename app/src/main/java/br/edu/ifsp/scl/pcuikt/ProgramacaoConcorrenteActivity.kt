import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import br.edu.ifsp.scl.pcuikt.R
import kotlinx.android.synthetic.main.activity_programacao_concorrente.*
import org.jetbrains.anko.imageResource

abstract class ProgramacaoConcorrenteActivity() : AppCompatActivity() {
    // Handler para alterar os ImageViews da thread mãe
    lateinit var carregaImagensHandler: CarregaImagensHandler
    // Constantes usadas pelo Handler
    companion object constantes {
        const val CARREGA_IMAGENS_MSG = 0
        const val CARREGA_IMAGENS_DELAY = 1000L
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_programacao_concorrente)
        // Instanciando o handler
        carregaImagensHandler = CarregaImagensHandler()
        // Chamando o método que preenche as imagens com o conteúdo
        carregaImagens()
    }
    /* Função abstrata que implementa como as imagens serão carregadas.
    Será implementada pelas classes filhas. */
    abstract fun run()
    fun carregaImagens() {
        /* Instancia uma thread com o método implementado pelas classes filhas */
        val carregaImagensThread: Thread = Thread{ run() }
        carregaImagensThread.start()
    }
    // Handler interno que preenche os ImageViews da Thread principal
    inner class CarregaImagensHandler : Handler() {
        override fun handleMessage(msg: Message?) {
            if (msg?.what == CARREGA_IMAGENS_MSG) {
                altaIv.imageResource = R.drawable.android_verde
                baixaIv.imageResource = R.drawable.android_preto
            }
        }
    }
}