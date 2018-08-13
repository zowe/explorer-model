/**
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright IBM Corporation 2018
 */

package com.ibm.atlas.model.datasets;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "CreateDataSetRequest", description = "Body for the create data set Request")
public class CreateDataSetRequest {

	// TODO - separate create pds and sds, allocate like requests and APIs?

	@ApiModelProperty(value = "Volume")
	private String volser;
	@ApiModelProperty(value = "Device Type")
	private String unit;
	@ApiModelProperty(value = "Data set organization", dataType = "string", required = true, allowableValues = "PO,PS")
	private DataSetOrganisationType dsorg;
	@ApiModelProperty(value = "Unit of space allocation", dataType = "string", required = true, allowableValues = "TRK, CYL")
	private AllocationUnitType alcunit;

	@ApiModelProperty(value = "Primary space allocation")
	private Integer primary;
	@ApiModelProperty(value = "Secondary space allocation")
	private Integer secondary;
	@ApiModelProperty(value = "Number of directory blocks")
	private Integer dirblk;
	@ApiModelProperty(value = "Average block")
	private Integer avgblk;

	// TODO convert to enum once we know which formats z/OS MF works with?
	@ApiModelProperty(value = "Record format", required = true)
	private String recfm;
	@ApiModelProperty(value = "Block size")
	private Integer blksize;
	@ApiModelProperty(value = "Record length", required = true)
	private Integer lrecl;

	@ApiModelProperty(value = "The dataset to base this new dataset on if it is an allocate like")
	private String basedsn;
	@ApiModelProperty(value = "The contents of the new dataset if it is an allocate like")
	private String records;

}