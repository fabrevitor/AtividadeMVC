package com.senac.vitor.control;

import android.widget.TextView;
import android.widget.Toast;

import com.senac.vitor.R;
import com.senac.vitor.model.Aluno;
import com.senac.vitor.model.AlunoBO;
import com.senac.vitor.view.MainActivity;

public class MainControl {
    private MainActivity activity;

    public MainControl(MainActivity activity){
        this.activity = activity;
    }

    public void calcularAction(){
        Aluno aluno = new Aluno();
        aluno.setNome(activity.getEditNome().getText().toString());
        aluno.setNota1(activity.getEditNota1().getText().toString());
        aluno.setNota2(activity.getEditNota2().getText().toString());

        if(validarDadosForm(aluno)){
            Double media = AlunoBO.calcularMedia(aluno);
            String txtResultadoAprovacao;
            if(AlunoBO.verificarAprovacao(aluno)){
                txtResultadoAprovacao = activity.getString(R.string.aprovado);
            } else{
                txtResultadoAprovacao = activity.getString(R.string.reprovado);
            }

            String txtResultadoFinal = "";

            /////////////////////////////////////
            //Resultado
            // forma estatica
            txtResultadoFinal += activity.getString(R.string.aluno) + ": " + aluno.getNome() + "\n";
            txtResultadoFinal += activity.getString(R.string.media) + ": " + media + "\n";
            txtResultadoFinal += activity.getString(R.string.situacao) + ": " + txtResultadoAprovacao;
            //Atualiza a tela com o resultado
            activity.getTvResultado().setText(txtResultadoFinal);

            //forma dinamica
            TextView tvResDinamico = new TextView(activity);
            tvResDinamico.setText(txtResultadoFinal);
            //activity.getLayoutResultado().removeAllViews(); // para retirar as outras views ja adicionadas
            activity.getLayoutResultado().addView((tvResDinamico));
            /////////////////////////////////////

            //Limpa o formulario digitado
            limparForm();
        } else{
            Toast.makeText(activity, "Form incompleto", Toast.LENGTH_SHORT).show();
        }
    }



    private boolean validarDadosForm(Aluno a){
        if(!AlunoBO.validarNome(a.getNome())){
            activity.getEditNome().setError(activity.getString(R.string.erro_nome));
            activity.getEditNome().requestFocus();
            return false;
        }

        if(!AlunoBO.validarNota(a.getNota1())){
            activity.getEditNota1().setError(activity.getString(R.string.erro_nota));
            activity.getEditNota1().requestFocus();
            return false;
        }
        if(!AlunoBO.validarNota(a.getNota2())){
            activity.getEditNota2().setError(activity.getString(R.string.erro_nota));
            activity.getEditNota2().requestFocus();
            return false;
        }
        return true;
    }

    public void limparDadosAction(){
        limparForm();
        activity.getTvResultado().setText("");
        activity.getLayoutResultado().removeAllViews();
    }

    private void limparForm(){
        activity.getEditNome().setText("");
        activity.getEditNota1().setText("");
        activity.getEditNota2().setText("");
        activity.getEditNome().requestFocus();
    }
}
