package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class CalcBB {
	private Double kwota;
	private Double czas;
	private Double wynik;

	@Inject
	FacesContext ctx;

	public Double getKwota() {
		return kwota;
	}

	public void setKwota(Double kwota) {
		this.kwota = kwota;
	}

	public Double getCzas() {
		return czas;
	}

	public void setCzas(Double czas) {
		this.czas = czas;
	}

	public Double getWynik() {
		return wynik;
	}

	public boolean doTheMath() {
		try {
			
			wynik = (kwota/czas);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	// Go to "showresult" if ok
	

		public String calc_AJAX() {
			if (doTheMath()) {
				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wynik: " + wynik, null));
			}
			return null;
		}
		

		public String info() {
			return "info";
		}
	}