/*******************************************************************************
 * Copyright (c) 2010-2015 Henshin developers. All rights reserved. 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TU Berlin, University of Luxembourg, SES S.A.
 *******************************************************************************/
class FIXML {
	Vector<Order> Order_objects = new Vector<Order>();

	FIXML() {
	}

	FIXML(Vector<Order> Order_list) {
		this.Order_objects = Order_list;
	}
}

class Order {
	String ClOrdID = "123456";
	String Side = "2";
	String TransactTm = "2001-09-11T09:30:47-05:00";
	String OrdTyp = "2";
	String Px = "93.25";
	String Acct = "26522154";
	Hdr Hdr_object = new Hdr();
	Instrmt Instrmt_object = new Instrmt();
	OrdQty OrdQty_object = new OrdQty();
	Hdr Hdr_object = new Hdr();
	Instrmt Instrmt_object = new Instrmt();
	OrdQty OrdQty_object = new OrdQty();

	Order() {
	}

	Order(String ClOrdID, String Side, String TransactTm, String OrdTyp,
			String Px, String Acct, Hdr Hdr_, Instrmt Instrmt_, OrdQty OrdQty_,
			Hdr Hdr_, Instrmt Instrmt_, OrdQty OrdQty_) {
		this.ClOrdID = ClOrdID;
		this.Side = Side;
		this.TransactTm = TransactTm;
		this.OrdTyp = OrdTyp;
		this.Px = Px;
		this.Acct = Acct;
		this.Hdr_object = Hdr_;
		this.Instrmt_object = Instrmt_;
		this.OrdQty_object = OrdQty_;
		this.Hdr_object = Hdr_;
		this.Instrmt_object = Instrmt_;
		this.OrdQty_object = OrdQty_;
	}
}

class Hdr {
	String Snt = "2001-09-11T09:30:47-05:00";
	String PosDup = "N";
	String PosRsnd = "N";
	String SeqNum = "521";
	Sndr Sndr_object = new Sndr();
	Tgt Tgt_object = new Tgt();
	Sndr Sndr_object = new Sndr();
	Tgt Tgt_object = new Tgt();

	Hdr() {
	}

	Hdr(String Snt, String PosDup, String PosRsnd, String SeqNum, Sndr Sndr_,
			Tgt Tgt_, Sndr Sndr_, Tgt Tgt_) {
		this.Snt = Snt;
		this.PosDup = PosDup;
		this.PosRsnd = PosRsnd;
		this.SeqNum = SeqNum;
		this.Sndr_object = Sndr_;
		this.Tgt_object = Tgt_;
		this.Sndr_object = Sndr_;
		this.Tgt_object = Tgt_;
	}
}

class Sndr {
	String ID = "AFUNDMGR";

	Sndr() {
	}

	Sndr(String ID) {
		this.ID = ID;
	}
}

class Tgt {
	String ID = "ABROKER";

	Tgt() {
	}

	Tgt(String ID) {
		this.ID = ID;
	}
}

class Instrmt {
	String Sym = "IBM";
	String ID = "459200101";
	String IDSrc = "1";

	Instrmt() {
	}

	Instrmt(String Sym, String ID, String IDSrc) {
		this.Sym = Sym;
		this.ID = ID;
		this.IDSrc = IDSrc;
	}
}

class OrdQty {
	String Qty = "1000";

	OrdQty() {
	}

	OrdQty(String Qty) {
		this.Qty = Qty;
	}
}