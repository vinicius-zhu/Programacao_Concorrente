import android.os.Bundle
import br.edu.ifsp.scl.pcuikt.R
import kotlinx.android.synthetic.main.activity_programacao_concorrente.*
import org.jetbrains.anko.imageResource
import java.lang.Thread.sleep

class RunOnUiThreadActivity: ProgramacaoConcorrenteActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = getString(R.string.metodo_activity)
    }
    /* Corpo da thread que será disparada pela thread mãe para tentar carregar as imagens
    No entanto, a thread filha, disparada pela mãe, chama o handler da thread mãe para solicitar
    o carregamento */
    override fun run() {
        /*O corpo da thread filha chama um método da Activity que acessa um handler IMPLÍCITO da classe
        mãe. Dessa forma, o carregamento pode ser feito diretamente sem acessar o handler instanciado. */
        runOnUiThread {
            sleep(CARREGA_IMAGENS_DELAY)
            altaIv.imageResource = R.drawable.android_verde
            baixaIv.imageResource = R.drawable.android_preto
        }
    }
}
