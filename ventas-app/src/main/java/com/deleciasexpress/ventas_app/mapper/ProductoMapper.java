package com.deleciasexpress.ventas_app.mapper;

import com.deleciasexpress.ventas_app.dto.ProductoRequestDTO;
import com.deleciasexpress.ventas_app.dto.ProductoResponseDTO;
import com.deleciasexpress.ventas_app.model.Producto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto toEntity(ProductoRequestDTO dto);

    ProductoResponseDTO toDto(Producto producto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void actulizarByDTO(ProductoRequestDTO dto, @MappingTarget Producto producto);
}
