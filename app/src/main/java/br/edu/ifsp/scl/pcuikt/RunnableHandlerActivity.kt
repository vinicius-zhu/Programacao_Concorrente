import android.os.Bundle
import br.edu.ifsp.scl.pcuikt.R
import kotlinx.android.synthetic.main.activity_programacao_concorrente.*
import org.jetbrains.anko.imageResource

class RunnableHandlerActivity : ProgramacaoConcorrenteActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Alterando o título da SupportActionBar
        supportActionBar?.title = getString(R.string.runnable_handler)
    }
    /* Corpo da thread que será disparada pela thread mãe para tentar carregar as imagens
    No entanto, a thread filha, disparada pela mãe, chama o handler da thread mãe para solicitar
    o carregamento */
    override fun run() {
        /* Envia um corpo para ser processado pelo Handler depois do delay CARREGA_IMAGENS_DELAY (ms)
        Esse corpo substitui o corpo da função handleMessage para esse caso específico.*/
        carregaImagensHandler.postDelayed(
            {
                altaIv.imageResource = R.drawable.android_verde
                baixaIv.imageResource = R.drawable.android_preto
            },
            CARREGA_IMAGENS_DELAY
        )
    }
}
