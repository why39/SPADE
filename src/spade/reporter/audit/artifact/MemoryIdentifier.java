/*
 --------------------------------------------------------------------------------
 SPADE - Support for Provenance Auditing in Distributed Environments.
 Copyright (C) 2015 SRI International

 This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU General Public License as
 published by the Free Software Foundation, either version 3 of the
 License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program. If not, see <http://www.gnu.org/licenses/>.
 --------------------------------------------------------------------------------
 */

package spade.reporter.audit.artifact;

import java.util.Map;

import spade.reporter.audit.OPMConstants;

public class MemoryIdentifier extends TransientArtifactIdentifier{
	
	private static final long serialVersionUID = -4838164396726143615L;
	private String memoryAddress;
	private String size;
	
	public MemoryIdentifier(String tgid, String tgidTime, String memoryAddress, String size){
		super(tgid, tgidTime);
		this.memoryAddress = memoryAddress;
		this.size = size;
	}
	
	public String getMemoryAddress(){
		return memoryAddress;
	}
		
	public String getSize(){
		return size;
	}

	@Override
	public Map<String, String> getAnnotationsMap() {
		Map<String, String> annotations = super.getAnnotationsMap();
		annotations.put(OPMConstants.ARTIFACT_MEMORY_ADDRESS, memoryAddress);
		annotations.put(OPMConstants.ARTIFACT_SIZE, size);
		return annotations;
	}
	
	public String getSubtype(){
		return OPMConstants.SUBTYPE_MEMORY_ADDRESS;
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((memoryAddress == null) ? 0 : memoryAddress.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(!super.equals(obj))
			return false;
		if(getClass() != obj.getClass())
			return false;
		MemoryIdentifier other = (MemoryIdentifier)obj;
		if(memoryAddress == null){
			if(other.memoryAddress != null)
				return false;
		}else if(!memoryAddress.equals(other.memoryAddress))
			return false;
		if(size == null){
			if(other.size != null)
				return false;
		}else if(!size.equals(other.size))
			return false;
		return true;
	}

	@Override
	public String toString(){
		return "MemoryIdentifier [memoryAddress=" + memoryAddress + ", size=" + size + ", tgid="
				+ getGroupId() + ", tgidTime=" + getGroupTime() + "]";
	}
}
