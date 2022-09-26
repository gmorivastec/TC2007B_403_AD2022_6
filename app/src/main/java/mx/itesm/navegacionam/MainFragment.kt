package mx.itesm.navegacionam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.findViewById<Button>(R.id.btnSimple).setOnClickListener {

            // queremos transitar hacia otro fragmento
            // OJO - utilizando en componente de navegación

            // lo primero es obtener referencia al controller
            // controller es el objeto que se encarga de a
            // administrar la navegación

            // 3 maneras de obtenerlo
            // 1 con actividad
            // - Activity.findNavController(id: Int)

            // 2 si tienes acceso a una view
            // - View.findNavController()

            // 3 si estás en un fragmento
            // - Fragment.findNavController()

            findNavController().navigate(
                R.id.action_mainFragment_to_simpleFragment
            )
        }

        view.findViewById<Button>(R.id.btnArgs).setOnClickListener {

            // vamos a utilizar el pase de parámetros
            // estamos utilizando un plugin de gradle que se llama
            // safe args
            // lo que hace es generar clases y métodos que restrinjan
            // los tipos de los argumentos

            val action = MainFragmentDirections.
            actionMainFragmentToArgsFragment(
                view.findViewById<EditText>(R.id.argString).text.toString(),
                view.findViewById<EditText>(R.id.argFloat).text.toString().toFloat()
            )

            findNavController().navigate(action)

        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}