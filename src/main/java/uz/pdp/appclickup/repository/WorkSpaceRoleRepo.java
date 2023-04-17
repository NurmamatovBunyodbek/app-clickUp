package uz.pdp.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appclickup.entity.WorkSpaceRole;

import java.util.UUID;

public interface WorkSpaceRoleRepo extends JpaRepository<WorkSpaceRole, UUID> {

}
