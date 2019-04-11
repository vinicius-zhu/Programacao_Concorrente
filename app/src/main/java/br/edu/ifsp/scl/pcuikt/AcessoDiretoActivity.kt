import android.os.Bundle
import br.edu.ifsp.scl.pcuikt.R
import kotlinx.android.synthetic.main.activity_programacao_concorrente.*
import org.jetbrains.anko.imageResource
import java.lang.Thread.sleep

class AcessoDiretoActivity : ProgramacaoConcorrenteActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Alterando o título da SupportActionBar
        supportActionBar?.title = getString(R.string.acesso_direto)
    }
    /* Corpo da thread que será disparada pela classe mãe para tentar carregar as imagens.
    No entanto, a thread filha com esse corpo, mesmo disparada pela principal,
    não pode acessar elementos de UI da thread mãe, causando uma exceção
    Exceção esperada: android.view.ViewRootImpl$CalledFromWrongThreadException:
    Only the original thread that created a view hierarchy can touch its views.*/
    override fun run() {
        // Dorme por CARREGA_IMAGENS_DELAY (ms)
        sleep(CARREGA_IMAGENS_DELAY)
        // Tenta acessar a UI da thread mãe DIRETAMENTE para carregar as imagens
        altaIv.imageResource = R.drawable.android_verde
        baixaIv.imageResource = R.drawable.android_preto
    }
}