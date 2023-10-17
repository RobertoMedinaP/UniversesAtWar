package universe.universesatwar.UI.VIew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import universe.universesatwar.R
import universe.universesatwar.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btentrar.setOnClickListener {
            if (guardarDatos()) {

                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }

        binding.tvsincuenta.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_sinCuentaFragment)

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun guardarDatos(): Boolean{
        val usuario= binding.textInputLayoutUsuario.editText?.text
        val contraseña= binding.textInputLayoutContraseA.editText?.text
        var valido=true



        if (usuario.isNullOrEmpty()){
            binding.textInputLayoutUsuario.editText?.error = "Ingrese su usuario"
        }
        valido=false

        if (contraseña.isNullOrEmpty()){
            binding.textInputLayoutContraseA.editText?.error = "Ingrese su contraseña"
        }
        valido=false
        return valido

    }
}