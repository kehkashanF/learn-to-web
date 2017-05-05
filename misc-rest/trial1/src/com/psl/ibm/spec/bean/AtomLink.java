package com.psl.ibm.spec.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "link")
public class AtomLink {
	private String href, type, rel;

	public AtomLink() {
		super();
	}

	public AtomLink(String href, String type, String rel) {
		super();
		this.href = href;
		this.type = type;
		this.rel = rel;
	}

	@XmlAttribute
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@XmlAttribute
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlAttribute
	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	@Override
	public String toString() {
		return "AtomLink [href=" + href + ", type=" + type + ", rel=" + rel
				+ "]";
	}

}
