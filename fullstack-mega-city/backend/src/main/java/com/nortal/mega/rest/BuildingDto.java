package com.nortal.mega.rest;

import com.nortal.mega.CustomValidator.LessThanOrEqual;
import com.nortal.mega.service.OnCreate;
import com.nortal.mega.service.OnUpdate;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

@Data
@Accessors(chain = true)
@LessThanOrEqual
public class BuildingDto {

    @NotNull(groups = OnUpdate.class)
    private Long id;

    @NotEmpty(message = "Name missing")
    private String name;

    @NotEmpty(message = "Address missing")
    private String address;

    @NotEmpty(message = "Index is missing")
    @Pattern(regexp = "NO.*", message = "Index must start with NO")
    private String index;

    @NotNull(groups = OnCreate.class, message = "Sector code missing")
    @Null(groups = OnUpdate.class)
    private String sectorCode;

    @NotNull(message = "Energy units missing")
    @Min(value = 1, message = "Energy units must be at least 1")
    private Integer energyUnits;

    @NotNull(groups = OnCreate.class, message = "Max energy unit missing")
    @Null(groups = OnUpdate.class)
    @Min(value = 1, groups = OnCreate.class, message = "Max energy must be at least 1")
    private Integer energyUnitMax;
}
