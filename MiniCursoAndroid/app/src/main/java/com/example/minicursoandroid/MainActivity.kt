package com.example.minicursoandroid

import android.content.Intent
import android.media.audiofx.AudioEffect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
   // private var textView : TextView
    //private var passWordUser:String?=null
    //private var emailUser:String?=null


    lateinit var recyclerView :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        val adapter=Adapter(listaAnuncio(),Glide.with(this))
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(this)
        adapter.click= this::openDescricao
        //textView=findViewById(R.id.text_boas_vindas)
        //intent.extras?.let {
           // emailUser=it.getString(LoginActivity.VALUE_EMAIL)
            //passWordUser=it.getString(LoginActivity.VALUE_PASSWORD)

        }
    private fun listaAnuncio() : List<Anuncio> {
        return listOf(
                Anuncio(
                        urlImage="https://s2.glbimg.com/o0ipniCnVLMmHV6ii74UbrRy1k0=/36x0:1747x1102/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2020/b/r/nZtMnQSbe3otM3CAAl4Q/apple-announce-iphone12pro-10132020.jpg",
                        title="Iphone 12",
                        price=14000.00,
                        date = "30 de Janeiro de 2020"
                ),

        Anuncio(
                urlImage= "https://img.olx.com.br/images/98/983912031496863.jpg",
                title="Uno 2012",
                price=15000.00,
                date = "25 de Julho de 2020"
        ),
        Anuncio(
                urlImage="https://images.adsttc.com/media/images/5d4d/f834/284d/d1d5/e200/02dd/large_jpg/FEATURED_IMAGE.jpg?1565390873",
                title="Casa na praia",
                price=250000.00,
                date = "29 de Abril de 2020"
        ),
            Anuncio(
                urlImage="https://conteudo.imguol.com.br/c/entretenimento/ee/2019/12/13/xbox-series-x-1576267709149_v2_1920x1080.jpg",
                title="Xbox Series x",
                price=5000.00,
                date = "23 de Março de 2020"
            ),
            Anuncio(
                urlImage="https://s2.glbimg.com/rEfHpBT6ejjhYqj1q8xYgvnfOhs=/0x0:893x514/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_bc8228b6673f488aa253bbcb03c80ec5/internal_photos/bs/2020/v/x/HjiF36S7SBfFnWUHVDfA/ps5.jpg",
                title="Ps5",
                price=5000.00,
                date = "25 de Julho de 2020"
            ),  Anuncio(
                urlImage="https://img.olx.com.br/images/93/938043199130606.jpg",
                title="Hornet 2010",
                price=20000.00,
                date = "25 de Dezembro de 2020"
            ),
            Anuncio(
                urlImage="https://3.bp.blogspot.com/-kJljcrbm-OY/V54qqbkebHI/AAAAAAACbL0/W1_Zxjg7pHsib5RFa6efVF6M8jsiuqi5QCLcB/s1600/Fusion-Titanium-2015%2B%252832%2529.JPG",
                title="Fusion 2015",
                price=50000.00,
                date = "10 de Junho de 2020"
            ),

                Anuncio(
                        urlImage="https://images.homify.com/c_fill,f_auto,h_500,q_auto,w_1280/v1553964637/p/photo/image/2986704/Casa_B_facahda_01-PS.jpg",
                        title="Casa Moderna",
                        price=550000.00,
                        date = "29 de Fevereiro de 2020"
                )

        )
    }

    override fun onBackPressed() {
        Toast.makeText(this,
                "Clique botão voltar",Toast.LENGTH_SHORT).show()
       super.onBackPressed()
    }
    //textView.text=emailUser
    fun openDescricao(){
        //val intent = Intent(this, DescricaoActivity::class.java)
        // startActivity(intent)
Toast.makeText(this,"Item clique",Toast.LENGTH_SHORT).show()

    }
    }


    // override fun onStart() {
      //  super.onStart()
    //}

    //override fun onResume() {
      //  super.onResume()
    //}

    //override fun onPause() {
      //  super.onPause()

    //}

    //override fun onStop() {
      //  super.onStop()
    //}

    //override fun onDestroy() {
        //
        //
        //
        //
        //
        //
      //  super.onDestroy()
    //}
