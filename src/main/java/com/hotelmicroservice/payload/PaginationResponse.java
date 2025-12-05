package com.hotelmicroservice.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponse {

	private Integer pageSize;

	private Integer pageNumber;

	private Long totalElements;

	private Integer totalPages;

	private boolean lastPage;
}
